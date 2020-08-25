package com.gildedrose;

import com.gildedrose.domain.AgedBrie;
import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testValuesDecrease() {
        Item[] items = new Item[] {
                Item.createItem("foo", 5, 5),
                Item.createItem("Elixir of the Mongoose", 6, 10),
                Item.createItem("+5 Dexterity Vest",5,5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[1].quality);
        assertEquals(5, app.items[1].sellIn);
        assertEquals(4, app.items[2].quality);
        assertEquals(4, app.items[2].sellIn);
        assertEquals("foo, 4, 4", app.items[0].toString());
        assertEquals("Elixir of the Mongoose, 5, 9", app.items[1].toString());
        assertEquals("+5 Dexterity Vest, 4, 4", app.items[2].toString());
    }

    @Test
    void testAgeBrieValueIncreases(){
        Item[] items = new Item[] {
                Item.createItem("Aged Brie", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void testAgedBriePastSellIn_ValueIncreasesDouble(){
        Item[] items = new Item[] {
                Item.createItem("Aged Brie", -1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void testItemPastSellIn_ValueDecreasesDouble(){
        Item[] items = new Item[] {
                Item.createItem("+5 Dexterity Vest", -1, 5),
                Item.createItem("Elixir of the Mongoose", -2, 6)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(4, app.items[1].quality);

    }

    @Test
    void testQualityNeverOver50(){
        Item[] items = new Item[] {
                Item.createItem("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testSulfurasAlways80Value(){
        Item[] items = new Item[] {
                Item.createItem("Sulfuras, Hand of Ragnaros", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
         assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void testConjuredItemDecreasesTwiceAsFast(){
        Item[] items = new Item[] {
                Item.createItem("Conjured Mana Cake", 5, 10),
                Item.createItem("Conjured Mana Cake", -1, 16)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    void testBackstagePassQuality0AfterSellIn(){
        Item[] items = new Item[] {
                Item.createItem("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityWith0to5SellIn(){
        Item[] items = new Item[] {
                Item.createItem("Backstage passes to a TAFKAL80ETC concert", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityWith5to10SellIn(){
        Item[] items = new Item[] {
                Item.createItem("Backstage passes to a TAFKAL80ETC concert", 7, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityWith10OrMoreSellIn(){
        Item[] items = new Item[] {
                Item.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

}
