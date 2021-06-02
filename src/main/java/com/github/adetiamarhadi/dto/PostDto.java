package com.github.adetiamarhadi.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_post")
public class PostDto extends PanacheEntity {

    @NotBlank(message = "title may not be blank")
    private String title;

    @NotBlank(message = "content may not be blank")
    private String content;

    @ManyToMany(mappedBy = "postDtoList")
    private List<TagDto> tagDtoList = new ArrayList<>();

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

    public void addTagDtoList(TagDto tagDto) {
        this.tagDtoList.add(tagDto);
    }
}
