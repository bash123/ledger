package org.ledger.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private String submitterFirstName;
    private String submitterLastName;
    private BigDecimal amount;
    private LocalDateTime transactionDateTime;
    private TransactionDirectionEnum direction;

    public Transaction(String submitterFirstName,
                       String submitterLastName,
                       BigDecimal amount,
                       LocalDateTime transactionDateTime,
                       TransactionDirectionEnum direction) {
        this.submitterFirstName = submitterFirstName;
        this.submitterLastName = submitterLastName;
        this.amount = amount;
        this.transactionDateTime = transactionDateTime;
        this.direction = direction;
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
