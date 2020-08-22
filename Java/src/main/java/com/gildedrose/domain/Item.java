package com.gildedrose.domain;

import java.util.Objects;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch(name){
            case "Aged Brie":
                return new AgedBrie(sellIn,quality);

            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(sellIn, quality);

            case "+5 Dexterity Vest":
                return new DexterityVest(sellIn, quality);

            case "Elixir of the Mongoose":
                return new MongooseElexir(sellIn, quality);

            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn);

            case "Conjured Mana Cake":
                return new ManaCake(sellIn, quality);

            default:
                return new Item(name, sellIn, quality);
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn &&
                quality == item.quality &&
                name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
