package com.github.adetiamarhadi.controller;

import com.github.adetiamarhadi.dto.Post;
import com.github.adetiamarhadi.dto.PostEntity;
import com.github.adetiamarhadi.exception.CustomException;
import com.github.adetiamarhadi.service.PostService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/post")
public class PostController {

    @Inject
    PostService postService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Post save(@Valid Post post) {

        return this.postService.save(post);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostEntity> getPostDtoList() {

        return this.postService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PostEntity getPostDto(@PathParam("id") String id) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        return this.postService.findById(Long.parseLong(id));
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PostEntity update(@PathParam("id") String id, Post post) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        this.postService.update(Long.parseLong(id), post);

        return this.postService.findById(Long.parseLong(id));
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        this.postService.delete(Long.parseLong(id));

        return Response.ok().build();
    }
}
