package org.example;

import org.example.exception.ChannelException;
import org.example.valueObject.Channel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InventoryRepoTest {

    private final static Channel validChannel = new Channel("channel-5");
    private final static String validMarket = "market-7";
    private final static String validStyle = "style-9";
    private final static String validSku = "br579-a";
    private final static String validDescription = "blue jeans";

    private InventoryRepo inventoryRepo;

    @BeforeEach
    public void setUp() {
        inventoryRepo = new InventoryRepo();
    }

    @Test
    @Disabled
    public void TestNullChannel() {
        Channel invalidChannel = new Channel(null);

        assertThatThrownBy(() -> inventoryRepo.LookUpItem(invalidChannel, validMarket, validStyle, validDescription))
                .isInstanceOf(ChannelException.class);
    }

    @Test
    public void TestNullMarket() {
        assertThatThrownBy(() -> inventoryRepo.LookUpItem(validChannel, null, validStyle, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestNullStyle() {
        assertThatThrownBy(() -> inventoryRepo.LookUpItem(validChannel, validMarket, null, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestNullDescription() {
        assertThatThrownBy(() -> inventoryRepo.LookUpItem(validChannel, validMarket, validStyle, null))
                .isInstanceOf(Exception.class);
    }

    @Test
    @Disabled
    public void TestInvalidChannel() {
        Channel invalidChannel = new Channel("ch");

        assertThatThrownBy(() -> inventoryRepo.LookUpItem(invalidChannel, validMarket, validStyle, validDescription))
                .isInstanceOf(ChannelException.class);
    }

    @Test
    public void TestInvalidMarket() {
        assertThatThrownBy(() -> inventoryRepo.LookUpItem(validChannel, "mkt", validStyle, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestInvalidStyle() {
        assertThatThrownBy(() -> inventoryRepo.LookUpItem(validChannel, validMarket, "styl", validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestInvalidDescription() {
        assertThatThrownBy(() -> inventoryRepo.LookUpItem(validChannel, validMarket, validStyle, ""))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestFindFakeItemByDescription() throws Exception {
        InventoryItem item = inventoryRepo.LookUpItem(validChannel, validMarket, validStyle, validDescription);
        assertThat(item.getDescription()).isEqualTo("blue jeans");
    }

    @Test
    public void TestFindFakeItemBySku() throws Exception {
        InventoryItem item = inventoryRepo.LookUpItem(validSku);
        assertThat(item.getDescription()).isEqualTo("blue jeans");
    }
}
