package com.github.adetiamarhadi.service;

import com.github.adetiamarhadi.dto.TagDto;
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
    public TagDto save(TagDto tagDto) {

        TagDto data = new TagDto();
        data.setLabel(tagDto.getLabel());

        this.tagRepository.persist(data);

        return data;
    }

    public List<TagDto> findAll() {

        return this.tagRepository.findAll().list();
    }

    public TagDto findById(Long id) {

        return this.tagRepository.findById(id);
    }

    @Transactional
    public TagDto update(Long id, TagDto tagDto) {

        TagDto data = this.tagRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("tag with id "+ id +" not found");
        }

        data.setLabel(tagDto.getLabel());

        this.tagRepository.persist(data);

        return data;
    }

    @Transactional
    public void delete(Long id) {

        TagDto data = this.tagRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);

        if (null == data) {
            throw new CustomException("tag with id "+ id +" not found");
        }

        this.tagRepository.deleteById(id);
    }
}
