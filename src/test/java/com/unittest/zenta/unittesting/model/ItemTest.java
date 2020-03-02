package com.unittest.zenta.unittesting.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItemTest {
    @Test
    public void testModelItemWithoutParameters(){
        Item item = new Item();
        item.setId(1);
        item.setName("Dragon Ball");
        item.setPrice(2000);
        item.setQuantity(10);
        item.setValue(1000);

        String expected = "Item{" +
                "id=" + 1 +
                ", name='" + "Dragon Ball" + '\'' +
                ", price=" + 2000 +
                ", quantity=" + 10 +
                ", value=" + 1000 +
                '}';

        assertEquals(expected,item.toString());
    }

    @Test
    public void testModelItemWithParameters(){
        Item item = new Item(1, "Dragon Ball", 2000, 10);
        assertEquals(1,item.getId());
    }
}
