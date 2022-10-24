package org.example.model;

import java.util.Objects;
import java.util.Optional;

public final class Channel {

    public static final int NAME_MIN_LENGTH = 7;
    private final String name;

    public Channel(String name) throws InvalidChannelException {
        Optional.ofNullable(name)
                .filter(n -> n.length() >= NAME_MIN_LENGTH)
                .orElseThrow(InvalidChannelException::createInvalidNameException);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(name, channel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
