package org.ledger.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LedgerApplicationExceptionMapper implements ExceptionMapper<LedgerApplicationException> {

    @Override
    public Response toResponse(LedgerApplicationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)  // You can choose a different status code like FORBIDDEN (403) or CONFLICT (409)
                .entity("{\"error\":\"" + exception.getMessage() + "\"}")
                .type("application/json")
                .build();
    }
}

