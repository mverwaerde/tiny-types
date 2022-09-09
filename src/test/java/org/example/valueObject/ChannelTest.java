package org.example.valueObject;

import org.example.exception.ChannelException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ChannelTest {

    private static Stream<String> invalidChannel() {
        return Stream.of(
                null,
                "ch"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidChannel")
    void createChannelShouldFailWhenChannelIsInvalid(String invalidChannel) {
        assertThatThrownBy(() -> new Channel(invalidChannel))
                .isInstanceOf(ChannelException.class);
    }

    @Test
    void createChannelShouldSuccessWhenChannelNameLenghtIsValid(){
        assertDoesNotThrow(() -> new Channel("channel-xxx"));
    }
}
