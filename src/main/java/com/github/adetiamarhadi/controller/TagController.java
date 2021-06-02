package com.github.adetiamarhadi.controller;

import com.github.adetiamarhadi.dto.TagDto;
import com.github.adetiamarhadi.exception.CustomException;
import com.github.adetiamarhadi.service.TagService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tag")
public class TagController {

    @Inject
    TagService tagService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TagDto save(@Valid TagDto tagDto) {

        return this.tagService.save(tagDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TagDto> getTagDtoList() {

        return this.tagService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TagDto getTagDto(@PathParam("id") String id) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        return this.tagService.findById(Long.parseLong(id));
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TagDto update(@PathParam("id") String id, @Valid TagDto tagDto) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        return this.tagService.update(Long.parseLong(id), tagDto);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {

        if (null == id || id.trim().length() == 0) {
            throw new CustomException("id may not be blank");
        }

        this.tagService.delete(Long.parseLong(id));

        return Response.ok().build();
    }
}
