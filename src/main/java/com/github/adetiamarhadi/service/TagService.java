package com.github.adetiamarhadi.service;

import com.github.adetiamarhadi.dto.TagEntity;
import com.github.adetiamarhadi.exception.CustomException;
import com.github.adetiamarhadi.repository.TagRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TagService {
    
    @Inject
    TagRepository tagRepository;

    @Transactional
    public TagEntity save(TagEntity tagEntity) {

        TagEntity data = new TagEntity();
        data.setLabel(tagEntity.getLabel());

        this.tagRepository.persist(data);

        return data;
    }

    public List<TagEntity> findAll() {

        return this.tagRepository.findAll().list();
    }

    public TagEntity findById(Long id) {

        return this.tagRepository.findById(id);
    }

    @Transactional
    public TagEntity update(Long id, TagEntity tagEntity) {

        TagEntity data = this.tagRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("tag with id "+ id +" not found");
        }

        data.setLabel(tagEntity.getLabel());

        this.tagRepository.persist(data);

        return data;
    }

    @Transactional
    public void delete(Long id) {

        TagEntity data = this.tagRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("tag with id "+ id +" not found");
        }

        this.tagRepository.deleteById(id);
    }
}
