package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassStrategyTest {

    @Test
    void increasesQualityByOneWhenMoreThanTenDaysRemain() {
        Item item = new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                15,
                20
        );

        new BackstagePassStrategy().update(item);

        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void increasesQualityByTwoWhenTenDaysOrLessRemain() {
        Item item = new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                10,
                20
        );

        new BackstagePassStrategy().update(item);

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void increasesQualityByThreeWhenFiveDaysOrLessRemain() {
        Item item = new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                5,
                20
        );

        new BackstagePassStrategy().update(item);

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void qualityDropsToZeroOnConcertDay() {
        Item item = new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                0,
                40
        );

        new BackstagePassStrategy().update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item item = new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                5,
                49
        );

        new BackstagePassStrategy().update(item);

        assertEquals(50, item.quality);
    }
}