package com.github.adetiamarhadi.repository;

import com.github.adetiamarhadi.dto.PostEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepository<PostEntity> {
}
