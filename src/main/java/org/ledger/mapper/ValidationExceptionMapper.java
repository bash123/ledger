package org.ledger.mapper;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.ledger.response.FailedViolationResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<FailedViolationResponse.Error> errorList = new ArrayList<>();

        for (ConstraintViolation<?> violation: exception.getConstraintViolations()) {
            String property =
                    Arrays.stream(violation.getPropertyPath().toString().split("\\."))
                            .reduce((s1, s2) -> s2).orElse("");
            errorList.add(new FailedViolationResponse.Error(property, violation.getMessage(), violation.getInvalidValue()));
        }

        FailedViolationResponse response = new FailedViolationResponse("Request validation failed", errorList);

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(response)
                .build();
    }
}

