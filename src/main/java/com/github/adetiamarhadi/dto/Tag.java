package com.github.adetiamarhadi.dto;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class Tag {

    private String id;

    @NotBlank(message = "label may not be blank")
    private String label;

    private Set<Post> postEntityList = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Post> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(Set<Post> postEntityList) {
        this.postEntityList = postEntityList;
    }
}
