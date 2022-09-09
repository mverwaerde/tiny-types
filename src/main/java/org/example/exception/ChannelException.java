package org.example.exception;

public class ChannelException extends RuntimeException {

    private static final String MESSAGE = "Invalid channel: ";

    public ChannelException(String message) {
        super(MESSAGE + message);
    }
}
