package com.unittest.zenta.unittesting.imp;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

    List<String> mockList = mock(List.class);

    @Test
    public void listTest(){
        when(mockList.size()).thenReturn(5);
        assertEquals(5,mockList.size());

    }

    @Test
    public void listDifferentValuesTest(){
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockList.size());
        assertEquals(10,mockList.size());

    }

    @Test
    public void returnWithParams(){
        when(mockList.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mockList.get(0));
        assertEquals(null,mockList.get(1));
    }

    @Test
    public void returnAnyParamaters(){
        when(mockList.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mockList.get(0));
        assertEquals("in28Minutes",mockList.get(1));
    }
    @Test
    public void verificationBasics(){
        String value = mockList.get(0);
        String value2 = mockList.get(1);

        verify(mockList).get(0);
        verify(mockList,times(2)).get(anyInt());
        verify(mockList,atLeast(1)).get(anyInt());
        verify(mockList,atLeastOnce()).get(anyInt());
        verify(mockList,atMost(2)).get(anyInt());
        verify(mockList,never()).get(2);
    }

    @Test
    public void multipleArgumentCapturing(){
        //sut
        mockList.add("SomeString");
        mockList.add("SomeString2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList,times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString",allValues.get(0));
        assertEquals("SomeString2",allValues.get(1));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        arrayListMock.get(0);//null
        arrayListMock.size(); //0
        arrayListMock.add("test");
        arrayListMock.add("test2");
        arrayListMock.size(); //0

        when(arrayListMock.size()).thenReturn(5);
        arrayListMock.size();//5

    }

    @Test
    public void spying(){
        ArrayList arrayListMock = spy(ArrayList.class);
        arrayListMock.add("test0");
        arrayListMock.get(0);//null
        System.out.println(arrayListMock.get(0));
        arrayListMock.size(); //1
        System.out.println(arrayListMock.size());
        arrayListMock.add("test");
        arrayListMock.add("test2");
        arrayListMock.size(); //0
        System.out.println(arrayListMock.size());

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());
        arrayListMock.add("test4");
        System.out.println(arrayListMock.size());

        verify(arrayListMock).add("test4");

    }



}
