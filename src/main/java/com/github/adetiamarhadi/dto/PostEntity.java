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
@Table(name = "tb_post")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PostEntity extends PanacheEntity {

    @NotBlank(message = "title may not be blank")
    private String title;

    @NotBlank(message = "content may not be blank")
    private String content;

    @ManyToMany(mappedBy = "postEntityList")
    private List<TagEntity> tagEntityList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addTagDtoList(TagEntity tagEntity) {
        this.tagEntityList.add(tagEntity);
    }

    public List<TagEntity> getTagEntityList() {
        return tagEntityList;
    }
}
