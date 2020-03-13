package com.unittest.zenta.unittesting.imp;

import com.unittest.zenta.unittesting.model.Item;
import com.unittest.zenta.unittesting.repository.IItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemImpTest {

    @InjectMocks
    private ItemImp itemImp = new ItemImp();

    @Mock
    private IItemRepository itemRepository = mock(IItemRepository.class);

    @Test
    public void calculateService(){
       when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(2,"item2",10,10),
                new Item(3,"item3",20,20)
        ));
        List<Item> itemList = itemImp.listItem();
        assertEquals(100,itemList.get(0).getValue());
        assertEquals(400,itemList.get(1).getValue());
    }

    @Test
    public void calculateItemDto(){
        Item itemReturn = itemImp.returnItemDto();
        Item item = new Item(1,"Dragon Ball",1000,2);
        assertEquals(item.getName(),itemReturn.getName());
    }



    /*
    @Test
    public void calculateService(){
        when(dataServiceMock.obtenerData()).thenReturn(new int[]{1,3,4});
        //assertEquals(8, businessImp.calculateSumDataService());
    }

    @Test
    public void calculateServiceValues(){
        when(dataServiceMock.calcularData(1,3,4)).thenReturn(new int[]{1,3,4});
       // assertEquals(8,businessImp.calculateSumDataServiceValues(1,3,4));
    }

    @Test
    public void calculateServiceEmpty(){
        when(dataServiceMock.obtenerData()).thenReturn(new int[]{});
        //assertEquals(0,businessImp.calculateSumDataService());
    }*/
}
