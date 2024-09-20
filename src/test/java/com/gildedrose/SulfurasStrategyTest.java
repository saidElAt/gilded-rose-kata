package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasStrategyTest {

    @Test
    void sulfurasNeverChanges() {
        Item item = new Item(
                "Sulfuras, Hand of Ragnaros",
                10,
                80
        );

        new SulfurasStrategy().update(item);

        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }
}