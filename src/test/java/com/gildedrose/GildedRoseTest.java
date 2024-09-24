package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updatesAllItemsUsingTheirAppropriateStrategies() {
        Item normalItem = new Item("Normal Item", 10, 20);
        Item agedBrie = new Item("Aged Brie", 10, 20);
        Item conjured = new Item("Conjured", 10, 20);
        Item sulfuras = new Item(
                "Sulfuras, Hand of Ragnaros",
                10,
                80
        );

        Item[] items = {
                normalItem,
                agedBrie,
                conjured,
                sulfuras
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(19, normalItem.quality);
        assertEquals(21, agedBrie.quality);
        assertEquals(18, conjured.quality);
        assertEquals(80, sulfuras.quality);

        assertEquals(9, normalItem.sellIn);
        assertEquals(9, agedBrie.sellIn);
        assertEquals(9, conjured.sellIn);
        assertEquals(10, sulfuras.sellIn);
    }
}