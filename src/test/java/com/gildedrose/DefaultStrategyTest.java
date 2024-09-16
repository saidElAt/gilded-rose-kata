package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultStrategyTest {

    @Test
    void decreasesQualityByOneBeforeSellDate() {
        Item item = new Item("Normal Item", 10, 20);

        new DefaultStrategy().update(item);

        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void decreasesQualityTwiceAsFastAfterSellDate() {
        Item item = new Item("Normal Item", 0, 20);

        new DefaultStrategy().update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void qualityNeverDropsBelowZero() {
        Item item = new Item("Normal Item", 10, 0);

        new DefaultStrategy().update(item);

        assertEquals(0, item.quality);
    }
}