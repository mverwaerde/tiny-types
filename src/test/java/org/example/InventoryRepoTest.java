package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InventoryRepoTest {

    private final static String validChannel = "channel-5";
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
    public void TestNullChannel() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(null, validMarket, validStyle, validDescription))
                .isInstanceOf(Exception.class);
    }
    @Test
    public void TestInvalidChannel() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem("ch", validMarket, validStyle, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestNullMarket() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(validChannel, null, validStyle, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestNullStyle() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(validChannel, validMarket, null, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestNullDescription() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(validChannel, validMarket, validStyle, null))
                .isInstanceOf(Exception.class);
    }


    @Test
    public void TestInvalidMarket() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(validChannel, "mkt", validStyle, validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestInvalidStyle() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(validChannel, validMarket, "styl", validDescription))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void TestInvalidDescription() {
        assertThatThrownBy(() ->
                inventoryRepo.LookUpItem(validChannel, validMarket, validStyle, ""))
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