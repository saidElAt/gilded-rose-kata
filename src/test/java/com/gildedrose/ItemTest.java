package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void convertsItemToReadableString() {
        Item item = new Item("Normal Item", 10, 20);

        assertEquals(
                "Normal Item, 10, 20",
                item.toString()
        );
    }
}