package com.github.adetiamarhadi.service;

import com.github.adetiamarhadi.dto.Post;
import com.github.adetiamarhadi.dto.PostEntity;
import com.github.adetiamarhadi.dto.Tag;
import com.github.adetiamarhadi.dto.TagEntity;
import com.github.adetiamarhadi.exception.CustomException;
import com.github.adetiamarhadi.repository.PostRepository;
import com.github.adetiamarhadi.repository.TagRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository postRepository;

    @Inject
    TagRepository tagRepository;

    @Transactional
    public Post save(Post post) {

        PostEntity data = new PostEntity();
        data.setTitle(post.getTitle());
        data.setContent(post.getContent());

        this.postRepository.persist(data);

        post.setId(String.valueOf(data.id));

        return post;
    }

    public List<PostEntity> findAll() {

        return this.postRepository.findAll().list();
    }

    public PostEntity findById(Long id) {

        return this.postRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Post post) {

        PostEntity data = this.postRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("post with id "+ id +" not found");
        }

        if (null != post && null != post.getTitle() && !post.getTitle().trim().isBlank()) {
            data.setTitle(post.getTitle());
        }

        if (null != post && null != post.getContent() && !post.getContent().trim().isBlank()) {
            data.setContent(post.getContent());
        }

        if (null != post.getTagEntityList() && !post.getTagEntityList().isEmpty()) {

            for (Tag tagId : post.getTagEntityList()) {
                if (null != tagId && (null == tagId.getId() || tagId.getId().isBlank()) && (null != tagId.getLabel() && !tagId.getLabel().isBlank())) {
                    // create new tag
                    TagEntity tagEntity = new TagEntity();
                    tagEntity.setLabel(tagId.getLabel());
                    tagEntity.addPostDtoList(data);
                    this.tagRepository.persist(tagEntity);

                    data.addTagDtoList(tagEntity);
                } else if (null != tagId && (null != tagId.getId() && !tagId.getId().isBlank())) {
                    // find existing tag
                    TagEntity byId = this.tagRepository.findById(Long.parseLong(tagId.getId()));
                    if (null != byId) {
                        byId.addPostDtoList(data);
                        data.addTagDtoList(byId);
                    }
                }
            }
        }

        this.postRepository.persist(data);
    }

    @Transactional
    public void delete(Long id) {

        PostEntity data = this.postRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("post with id "+ id +" not found");
        }

        this.postRepository.deleteById(id);
    }
}
