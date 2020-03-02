package com.unittest.zenta.unittesting.imp;

import com.unittest.zenta.unittesting.model.Item;
import com.unittest.zenta.unittesting.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImp {

    @Autowired
    private IItemRepository iItemRepository;

    public Item returnItemDto(){
        return new Item(1,"Dragon Ball",1000,2);
    }

    public List<Item> listItem(){
        List<Item> listItem = iItemRepository.findAll();
        for (Item item:listItem) {
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return listItem;
    }

    /*
    @Autowired
    private DataService dataService;



    public int calculateSumDataServiceValues(int valueA,int valueB, int valueC){
        int sum = 0;
        int[] data = dataService.calcularData(valueA,valueB,valueC);
        for (int value: data){
            sum += value;
        }
        return sum;
    }

    public int calculateSumDataService(){
        int sum = 0;
        int data[] = dataService.obtenerData();
        for (int value: data){
            sum += value;
        }
        return sum;
    }*/
}
