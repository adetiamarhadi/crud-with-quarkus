package com.github.adetiamarhadi.service;

import com.github.adetiamarhadi.dto.PostDto;
import com.github.adetiamarhadi.exception.CustomException;
import com.github.adetiamarhadi.repository.PostRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository postRepository;

    @Transactional
    public PostDto save(PostDto postDto) {

        PostDto data = new PostDto();
        data.setTitle(postDto.getTitle());
        data.setContent(postDto.getContent());

        this.postRepository.persist(data);

        return data;
    }

    public List<PostDto> findAll() {

        return this.postRepository.findAll().list();
    }

    public PostDto findById(Long id) {

        return this.postRepository.findById(id);
    }

    @Transactional
    public PostDto update(Long id, PostDto postDto) {

        PostDto data = this.postRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("post with id "+ id +" not found");
        }

        data.setTitle(postDto.getTitle());
        data.setContent(postDto.getContent());

        this.postRepository.persist(data);

        return data;
    }

    @Transactional
    public void delete(Long id) {

        PostDto data = this.postRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("post with id "+ id +" not found");
        }

        this.postRepository.deleteById(id);
    }
}
