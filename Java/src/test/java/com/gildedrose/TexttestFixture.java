package com.gildedrose;

import com.gildedrose.domain.*;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new DexterityVest( 10, 20), //
                new AgedBrie( 2, 0), //
                new MongooseElexir( 5, 7), //
                new Sulfuras( 0), //
                new Sulfuras( -1),
                new BackstagePass( 15, 20),
                new BackstagePass( 10, 49),
                new BackstagePass( 5, 49),
                // this conjured item does not work properly yet
                new ManaCake( 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
