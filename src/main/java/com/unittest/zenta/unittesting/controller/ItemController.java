package com.unittest.zenta.unittesting.controller;

import com.unittest.zenta.unittesting.model.Item;
import com.unittest.zenta.unittesting.imp.ItemImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hello-world")
public class ItemController {

    @Autowired
    private ItemImp itemImp;

    @RequestMapping(method = RequestMethod.GET)
    public String getHelloWorld(){
        return "hello world";
    }

    @RequestMapping(value = "/item",method = RequestMethod.GET)
    public Item getItems(){
        return itemImp.returnItemDto();
    }

    @RequestMapping(value = "/item-list",method = RequestMethod.GET)
    public List<Item> getListItems(){
        return itemImp.listItem();
    }
}
