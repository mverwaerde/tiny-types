package org.example.model;

public class InvalidChannelException extends Exception {
    private InvalidChannelException(String message) {
        super(message);
    }

    public static final InvalidChannelException createInvalidNameException(){
        return new InvalidChannelException("invalid  name");
    }
}
