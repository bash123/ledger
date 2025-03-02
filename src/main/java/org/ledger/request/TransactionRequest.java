package org.ledger.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class TransactionRequest {

    @NotNull(message = "submitterFirstName cannot be null")
    @Pattern(regexp = "^[a-zA-Z]{1,255}$", message = "Invalid name, use letters only up to 255 characters.") //Database constrain
    private String submitterFirstName;

    @NotNull(message = "submitterLastName cannot be null")
    @Pattern(regexp = "^[a-zA-Z]{1,255}$", message = "Invalid name, use letters only up to 255 characters.") //Database constrain
    private String submitterLastName;

    @NotNull(message = "amount cannot be null")
    @DecimalMin(value = "0.01", message = "amount must be equal to or greater than 0.01")
    @Digits(integer=6, fraction=2, message = "amount must be under 1 million with maximum 2 decimal points") //Fat finger safeguard
    private BigDecimal amount;

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
}
