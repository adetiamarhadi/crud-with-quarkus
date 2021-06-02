package com.github.adetiamarhadi.exception;

import com.github.adetiamarhadi.dto.ResponseCodeDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        ResponseCodeDto responseCodeDto = new ResponseCodeDto(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                "the request can not be processed");
        return Response.status(Response.Status.BAD_REQUEST).entity(responseCodeDto).build();
    }
}
