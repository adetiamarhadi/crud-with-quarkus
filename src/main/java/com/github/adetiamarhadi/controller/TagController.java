package com.github.adetiamarhadi.controller;

import com.github.adetiamarhadi.dto.TagDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/tag")
public class TagController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TagDto save(TagDto tagDto) {

        TagDto response = new TagDto(UUID.randomUUID().toString(), "Programming", List.of());

        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TagDto> getTagDtoList() {

        TagDto tagDto = new TagDto(UUID.randomUUID().toString(), "Programming", List.of());

        TagDto tagDto2 = new TagDto(UUID.randomUUID().toString(), "Science", List.of());

        return List.of(tagDto, tagDto2);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TagDto getTagDto(@PathParam("id") String id) {

        TagDto tagDto = new TagDto(id, "Programming", List.of());

        return tagDto;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TagDto update(@PathParam("id") String id, TagDto tagDto) {

        TagDto response = new TagDto(id,
                tagDto.getLabel(),
                List.of());

        return response;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        return Response.ok().build();
    }
}
