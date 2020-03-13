package com.unittest.zenta.unittesting.controller;


import com.unittest.zenta.unittesting.model.Item;
import com.unittest.zenta.unittesting.imp.ItemImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerBackupTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemImp itemImp;

    @Test
    public void getHelloWorld() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders
                                .get("/api/v1/hello-world")
                                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("hello world"))
                .andReturn();
        assertEquals("hello world",result.getResponse().getContentAsString());
    }

    @Test
    public void getAllItems() throws Exception{
        when(itemImp.listItem()).thenReturn(
                Arrays.asList(
                        new Item(2,"item2",10,10),
                        new Item(3,"item3",20,20)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/hello-world/item-list")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"item2\",\n" +
                        "    \"price\": 10,\n" +
                        "    \"quantity\": 10,\n" +
                        "    \"value\": 0\n" +
                        "  }," +
                                "{\n" +
                        "    \"id\": 3,\n" +
                                "    \"name\": \"item3\",\n" +
                                "    \"price\": 20,\n" +
                                "    \"quantity\": 20,\n" +
                                "    \"value\": 0\n" +
                                "  }"+
                        "]"))
                .andReturn();
        //assertEquals("hello world",result.getResponse().getContentAsString());
    }

    @Test
    public void getItemBusinnessService() throws Exception{
        //"api/v1/hello-world"

        when(itemImp.returnItemDto()).thenReturn(new Item(1,"Dragon Ball",1000,2));

        //construyendo una request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/hello-world/item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"name\": \"Dragon Ball\",\n" +
                        "  \"price\": 1000,\n" +
                        "  \"quantity\": 2\n" +
                        "}"))
                .andReturn();



    }
}
