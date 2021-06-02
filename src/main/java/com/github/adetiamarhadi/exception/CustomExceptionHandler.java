package com.github.adetiamarhadi.exception;

import com.github.adetiamarhadi.dto.ResponseCodeDto;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException> {
    @Override
    public Response toResponse(CustomException e) {
        ResponseCodeDto responseCodeDto = new ResponseCodeDto(Response.Status.BAD_REQUEST.getStatusCode(),
                e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(responseCodeDto).build();
    }
}
