package com.github.adetiamarhadi.dto;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Post {

    private String id;

    @NotBlank(message = "title may not be blank")
    private String title;

    @NotBlank(message = "content may not be blank")
    private String content;

    private Set<Tag> tagEntityList = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Set<Tag> getTagEntityList() {
        return tagEntityList;
    }

    public void setTagEntityList(Set<Tag> tagEntityList) {
        this.tagEntityList = tagEntityList;
    }
}
