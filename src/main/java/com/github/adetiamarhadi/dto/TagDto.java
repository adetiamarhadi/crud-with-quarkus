package com.github.adetiamarhadi.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tag")
public class TagDto extends PanacheEntity {

    @NotBlank(message = "label may not be blank")
    private String label;

    @ManyToMany
    private List<PostDto> postDtoList = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addPostDtoList(PostDto postDto) {
        this.postDtoList.add(postDto);
    }
}
