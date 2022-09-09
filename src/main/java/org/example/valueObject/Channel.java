package org.example.valueObject;

import org.example.exception.ChannelException;

public record Channel(String name) {

    public static final int MIN_LENGTH = 7;

    public Channel(String name) {
        if (name == null) {
            throw new ChannelException("channel is null");
        }
        if (name.length() < MIN_LENGTH) {
            throw new ChannelException("channel length is inferior to " + MIN_LENGTH);
        }
        this.name = name;
    }
}
