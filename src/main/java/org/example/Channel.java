package org.example;

import java.util.Objects;

public final class Channel {

    private final String name;

    Channel(String name) throws Exception {
        if (name == null || name.length() < 7) {
            throw new Exception("Invalid Channel");
        }
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
