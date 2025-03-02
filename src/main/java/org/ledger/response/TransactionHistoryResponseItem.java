package org.ledger.response;

import org.ledger.services.Transaction;
import org.ledger.services.TransactionDirectionEnum;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionHistoryResponseItem {

    private UUID transactionID;
    private TransactionDirectionEnum direction;
    private BigDecimal amount;


    public TransactionHistoryResponseItem(UUID uuid, Transaction transaction) {
        this.transactionID = uuid;
        this.direction = transaction.getDirection();
        this.amount = transaction.getAmount();
    }

    public UUID getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(UUID transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionDirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(TransactionDirectionEnum direction) {
        this.direction = direction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
