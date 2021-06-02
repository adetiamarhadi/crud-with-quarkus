package com.github.adetiamarhadi.controller;

import com.github.adetiamarhadi.dto.PostDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/post")
public class PostController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PostDto save(PostDto postDto) {

        PostDto response = new PostDto(UUID.randomUUID().toString(),
                postDto.getTitle(),
                postDto.getContent(),
                List.of());

        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostDto> getPostDtoList() {

        PostDto postDto = new PostDto(UUID.randomUUID().toString(),
                "Java Master",
                "Java from Beginner to Master",
                List.of());

        PostDto postDto2 = new PostDto(UUID.randomUUID().toString(),
                "Angular Master",
                "Angular from Beginner to Master",
                List.of());

        return List.of(postDto, postDto2);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PostDto getPostDto(@PathParam("id") String id) {

        PostDto postDto = new PostDto(id,
                "Java Master",
                "Java from Beginner to Master",
                List.of());

        return postDto;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PostDto update(@PathParam("id") String id, PostDto postDto) {

        PostDto response = new PostDto(id,
                postDto.getTitle(),
                postDto.getContent(),
                List.of());

        return response;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        return Response.ok().build();
    }
}
