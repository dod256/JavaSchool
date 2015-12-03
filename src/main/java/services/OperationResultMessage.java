package main.java.services;

public class OperationResultMessage {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public OperationResultMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
