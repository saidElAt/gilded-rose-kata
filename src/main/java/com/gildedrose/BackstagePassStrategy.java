package com.gildedrose;

public class BackstagePassStrategy implements UpdateStrategy {

    @Override
    public void update(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            adjustQualityBasedOnSellIn(item);
        }

        item.sellIn--;
    }

    private void adjustQualityBasedOnSellIn(Item item) {
        if (item.sellIn <= 5) {
            increaseQuality(item, 3);
        } else if (item.sellIn <= 10) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(item.quality + amount, 50);
    }
}