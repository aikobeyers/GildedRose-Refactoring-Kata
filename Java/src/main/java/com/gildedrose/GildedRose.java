package com.gildedrose;

import com.gildedrose.domain.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            doUpdateQuality(item);
        }
    }

    private void doUpdateQuality(Item item) {
        if (item.quality >= 50 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = 50;
        }
        switch (item.name){
            case "Aged Brie":
                if(item.quality < 50 && item.sellIn > 0) {
                    ++item.quality;
                } else if(item.quality < 50){
                    //Niet expliciet vermeld of de "Once the sell by date has passed, Quality degrades twice as fast" ook geldt bij de Aged Brie als double quality increase
                    item.quality = item.quality + 2;
                }
                --item.sellIn;

                break;
            case "Backstage passes to a TAFKAL80ETC concert":

                if(item.sellIn < 0) {
                    item.quality = 0;
                } else {
                    if(item.quality < 50) {
                        if(item.sellIn <= 5){
                            item.quality = item.quality + 3;
                        } else if(item.sellIn <= 10){
                            item.quality = item.quality + 2;
                        } else {
                            ++item.quality;
                        }
                    }
                }
                break;

            case "Sulfuras, Hand of Ragnaros":
                break;

            case "Conjured Mana Cake":
                if (item.quality > 0 && item.sellIn >0) {
                    item.quality = item.quality - 2;
                } else {
                    item.quality = item.quality - 4;
                }

                --item.sellIn;
                break;

            case "+5 Dexterity Vest":
            case "Elixir of the Mongoose":
            default:
                if (item.quality > 0 && item.sellIn >0) {
                    --item.quality;
                } else {
                    item.quality = item.quality - 2;
                }

                --item.sellIn;

                break;

        }
/*
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }*/
    }
}
