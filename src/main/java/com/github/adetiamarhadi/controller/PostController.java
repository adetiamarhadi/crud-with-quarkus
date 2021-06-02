package com.github.adetiamarhadi.controller;

import com.github.adetiamarhadi.dto.PostDto;
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
    public PostDto save(@Valid PostDto postDto) {

        return this.postService.save(postDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostDto> getPostDtoList() {

        return this.postService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PostDto getPostDto(@PathParam("id") String id) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        return this.postService.findById(Long.parseLong(id));
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PostDto update(@PathParam("id") String id, @Valid PostDto postDto) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        return this.postService.update(Long.parseLong(id), postDto);
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
