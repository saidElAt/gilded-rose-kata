package com.gildedrose;

public class ConjuredStrategy implements UpdateStrategy {

    @Override
    public void update(Item item) {
        decreaseQuality(item, 2);
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality(item, 2);
        }
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(item.quality - amount, 0);
    }
}