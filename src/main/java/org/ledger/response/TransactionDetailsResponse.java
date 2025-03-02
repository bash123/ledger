package org.ledger.response;

import org.ledger.services.Transaction;
import org.ledger.services.TransactionDirectionEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDetailsResponse {

    private String submitterFirstName;
    private String submitterLastName;
    private BigDecimal amount;
    private LocalDateTime transactionDateTime;
    private TransactionDirectionEnum direction;

    public TransactionDetailsResponse(Transaction transaction) {
        this.submitterFirstName = transaction.getSubmitterFirstName();
        this.submitterLastName = transaction.getSubmitterLastName();
        this.amount = transaction.getAmount();
        this.transactionDateTime = transaction.getTransactionDateTime();
        this.direction = transaction.getDirection();
    }

    public String getSubmitterFirstName() {
        return submitterFirstName;
    }

    public void setSubmitterFirstName(String submitterFirstName) {
        this.submitterFirstName = submitterFirstName;
    }

    public String getSubmitterLastName() {
        return submitterLastName;
    }

    public void setSubmitterLastName(String submitterLastName) {
        this.submitterLastName = submitterLastName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public TransactionDirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(TransactionDirectionEnum direction) {
        this.direction = direction;
    }
}
