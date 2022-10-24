package org.example;

import org.example.model.Channel;

/**
 * InventoryManager - a facade to the database facade for inventory
 */
public class InventoryRepo {
    public InventoryItem LookUpItem(String channelName, String market, String styleCode, String description) throws Exception {
        Channel channel = new Channel(channelName);
        if (market == null || market.length() < 4 || market.length() > 8) {
            throw new Exception("Invalid market");
        }
        if (styleCode == null || styleCode.length() < 5 || styleCode.length() > 10) {
            throw new Exception("Invalid style code");
        }
        if (description == null) {
            throw new Exception("Invalid description");
        }
        DatabaseManager dbmgr = new DatabaseManager("Inventory");
        if (!dbmgr.FindChannel(channel.getName())) {
            throw new Exception("Invalid channelName");
        }
        if (!dbmgr.FindMarket(market)) {
            throw new Exception("Invalid market");
        }
        if (!dbmgr.FindStyle(styleCode)) {
            throw new Exception("Invalid style code");
        }
        InventoryItem item = (InventoryItem) dbmgr.FindItem(styleCode, market, description, channelName);
        if (item == null) {
            return null;
        }
        return item;
    }

    public InventoryItem LookUpItem(String sku) throws Exception {
        if (sku == null || sku.length() < 6 || sku.length() > 10) {
            throw new Exception("Invalid sku");
        }
        DatabaseManager dbmgr = new DatabaseManager("Inventory");
        InventoryItem item = (InventoryItem) dbmgr.FindItem(sku);
        if (item == null) {
            return null;
        }
        return item;
    }
}
