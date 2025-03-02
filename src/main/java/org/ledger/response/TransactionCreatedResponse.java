package org.ledger.response;

import java.util.UUID;

public class TransactionCreatedResponse {

    private UUID transactionID;
    private String message;

    public TransactionCreatedResponse() {
    }

    public TransactionCreatedResponse(UUID transactionID, String message) {
        this.transactionID = transactionID;
        this.message = message;
    }

    public UUID getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(UUID transactionID) {
        this.transactionID = transactionID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
