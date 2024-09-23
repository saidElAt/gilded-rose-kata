package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class StrategyRegistryTest {

    @Test
    void returnsAgedBrieStrategy() {
        UpdateStrategy strategy =
                StrategyRegistry.getStrategy("Aged Brie");

        assertInstanceOf(AgedBrieStrategy.class, strategy);
    }

    @Test
    void returnsSulfurasStrategy() {
        UpdateStrategy strategy =
                StrategyRegistry.getStrategy("Sulfuras, Hand of Ragnaros");

        assertInstanceOf(SulfurasStrategy.class, strategy);
    }

    @Test
    void returnsBackstagePassStrategy() {
        UpdateStrategy strategy =
                StrategyRegistry.getStrategy(
                        "Backstage passes to a TAFKAL80ETC concert"
                );

        assertInstanceOf(BackstagePassStrategy.class, strategy);
    }

    @Test
    void returnsConjuredStrategy() {
        UpdateStrategy strategy =
                StrategyRegistry.getStrategy("Conjured");

        assertInstanceOf(ConjuredStrategy.class, strategy);
    }

    @Test
    void returnsDefaultStrategyForUnknownItems() {
        UpdateStrategy strategy =
                StrategyRegistry.getStrategy("Normal Item");

        assertInstanceOf(DefaultStrategy.class, strategy);
    }
}