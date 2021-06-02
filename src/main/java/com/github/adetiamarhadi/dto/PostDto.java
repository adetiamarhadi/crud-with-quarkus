package com.github.adetiamarhadi.dto;

import java.util.List;

public class PostDto {

    private String id;
    private String title;
    private String content;
    private List<TagDto> tagDtoList;

    public PostDto(String id, String title, String content, List<TagDto> tagDtoList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tagDtoList = tagDtoList;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<TagDto> getTagDtoList() {
        return tagDtoList;
    }
}
