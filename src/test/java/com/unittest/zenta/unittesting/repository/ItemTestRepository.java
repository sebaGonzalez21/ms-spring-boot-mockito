package com.unittest.zenta.unittesting.repository;

import com.unittest.zenta.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTestRepository {

    @Autowired
    private IItemRepository itemRepository;

    @Test
    public void findAll(){
        List<Item> items =  itemRepository.findAll();


        assertEquals(3,items.size());
    }
}
