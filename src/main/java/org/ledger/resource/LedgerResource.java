package org.ledger.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ledger.mapper.LedgerApplicationException;
import org.ledger.request.TransactionRequest;
import org.ledger.response.BalanceResponse;
import org.ledger.response.TransactionCreatedResponse;
import org.ledger.response.TransactionDetailsResponse;
import org.ledger.response.TransactionHistoryResponseItem;
import org.ledger.services.LedgerService;
import org.ledger.services.Transaction;

import java.util.List;
import java.util.UUID;

@Path("/ledger")
public class LedgerResource {

    @Inject
    LedgerService ledgerService;

    @GET
    @Path("/balance")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBalance() {
        return Response.ok()
                .entity(new BalanceResponse(ledgerService.getBalance()))
                .build();
    }

    @GET
    @Path("/transaction-history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactions() {
        List<TransactionHistoryResponseItem> transactionHistory = ledgerService.getTransactionHistory();

        return Response.ok()
                .entity(transactionHistory)
                .build();
    }

    @GET
    @Path("/transaction-details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionDetail(@NotNull @PathParam("id") UUID id) throws LedgerApplicationException {
        Transaction transaction = ledgerService.getTransactionDetail(id);

        return Response.ok()
                .entity(new TransactionDetailsResponse(transaction))
                .build();
    }

    @PUT
    @Path("/deposit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeDeposit(@Valid TransactionRequest transactionRequest) {
        UUID uuid = ledgerService.makeDeposit(transactionRequest);

        return Response
                .status(201)
                .entity(new TransactionCreatedResponse(uuid, "Transaction entered successfully"))
                .build();
    }

    @PUT
    @Path("/withdrawal")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeWithdrawal(@Valid TransactionRequest transactionRequest) throws LedgerApplicationException {
        UUID uuid = ledgerService.makeWithdrawal(transactionRequest);

        return Response
                .status(201)
                .entity(new TransactionCreatedResponse(uuid, "Transaction entered successfully"))
                .build();
    }
}
