package com.gildedrose;

import com.gildedrose.domain.AgedBrie;
import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testValuesDecrease_Succeeds() {
        Item[] items = new Item[] {
                Item.createItem("foo", 5, 5),
                Item.createItem("+5 Dexterity Vest",5,5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        //assertEquals(4, app.items[1].quality);
    }
}
