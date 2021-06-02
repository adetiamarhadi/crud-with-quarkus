package com.github.adetiamarhadi.exception;

import com.github.adetiamarhadi.dto.ResponseCodeDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        ResponseCodeDto responseCodeDto = new ResponseCodeDto(Response.Status.BAD_REQUEST.getStatusCode(),
                e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
        return Response.status(Response.Status.BAD_REQUEST).entity(responseCodeDto).build();
    }
}
