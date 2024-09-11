package com.gildedrose;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = StrategyRegistry.getStrategy(item.name);
            strategy.update(item);
        }
    }
}