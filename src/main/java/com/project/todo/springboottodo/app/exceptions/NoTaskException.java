package com.project.todo.springboottodo.app.exceptions;

public class NoTaskException extends RuntimeException {
    private String message;
    public NoTaskException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
