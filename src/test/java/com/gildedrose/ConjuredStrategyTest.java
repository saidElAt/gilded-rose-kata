package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredStrategyTest {

    @Test
    void decreasesQualityByTwoBeforeSellDate() {
        Item item = new Item("Conjured", 10, 20);

        new ConjuredStrategy().update(item);

        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void decreasesQualityByFourAfterSellDate() {
        Item item = new Item("Conjured", 0, 20);

        new ConjuredStrategy().update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(16, item.quality);
    }

    @Test
    void qualityNeverDropsBelowZero() {
        Item item = new Item("Conjured", 10, 1);

        new ConjuredStrategy().update(item);

        assertEquals(0, item.quality);
    }
}