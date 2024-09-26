package com.gildedrose;

public class Main {

    public static void main(String[] args) {

        Item[] items = {
                new Item("Normal Item", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Conjured", 3, 6)
        };

        GildedRose gildedRose = new GildedRose(items);

        System.out.println("=== Gilded Rose ===");
        System.out.println();

        System.out.println("Day 0:");
        printItems(items);

        gildedRose.updateQuality();

        System.out.println();
        System.out.println("Day 1:");
        printItems(items);
    }

    private static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}