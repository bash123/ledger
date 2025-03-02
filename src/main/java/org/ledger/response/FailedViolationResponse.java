package org.ledger.response;

import java.util.List;

public class FailedViolationResponse {
    private String message;
    private List<Error> errors;

    public FailedViolationResponse(String message, List<Error> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public static class Error {
        private String attribute;
        private String message;
        private Object rejectedValue;

        public Error(String attribute, String message, Object rejectedValue) {
            this.attribute = attribute;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }

        public void setRejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
        }
    }
}


