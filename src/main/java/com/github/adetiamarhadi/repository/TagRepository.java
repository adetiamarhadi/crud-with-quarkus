package com.github.adetiamarhadi.repository;

import com.github.adetiamarhadi.dto.TagEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TagRepository implements PanacheRepository<TagEntity> {
}
