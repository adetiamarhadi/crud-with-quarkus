package com.github.adetiamarhadi.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tag")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TagEntity extends PanacheEntity {

    @NotBlank(message = "label may not be blank")
    private String label;

    @ManyToMany
    private List<PostEntity> postEntityList = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addPostDtoList(PostEntity postEntity) {
        this.postEntityList.add(postEntity);
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }
}
