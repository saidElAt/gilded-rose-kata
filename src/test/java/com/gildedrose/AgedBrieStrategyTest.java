package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieStrategyTest {

    @Test
    void increasesQualityByOneBeforeSellDate() {
        Item item = new Item("Aged Brie", 10, 20);

        new AgedBrieStrategy().update(item);

        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void increasesQualityTwiceAsFastAfterSellDate() {
        Item item = new Item("Aged Brie", 0, 20);

        new AgedBrieStrategy().update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item item = new Item("Aged Brie", 10, 50);

        new AgedBrieStrategy().update(item);

        assertEquals(50, item.quality);
    }
}