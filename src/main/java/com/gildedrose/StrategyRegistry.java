package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class StrategyRegistry {

    private static final Map<String, UpdateStrategy> STRATEGY_MAP = new HashMap<>();

    static {
        STRATEGY_MAP.put("Aged Brie", new AgedBrieStrategy());
        STRATEGY_MAP.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
        STRATEGY_MAP.put(
                "Backstage passes to a TAFKAL80ETC concert",
                new BackstagePassStrategy()
        );
        STRATEGY_MAP.put("Conjured", new ConjuredStrategy());
    }

    public static UpdateStrategy getStrategy(String itemName) {
        return STRATEGY_MAP.getOrDefault(itemName, new DefaultStrategy());
    }
}