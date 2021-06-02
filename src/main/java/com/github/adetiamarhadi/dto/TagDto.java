package com.github.adetiamarhadi.dto;

import java.util.List;

public class TagDto {

    private String id;
    private String label;
    private List<PostDto> postDtoList;

    public TagDto(String id, String label, List<PostDto> postDtoList) {
        this.id = id;
        this.label = label;
        this.postDtoList = postDtoList;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public List<PostDto> getPostDtoList() {
        return postDtoList;
    }
}
