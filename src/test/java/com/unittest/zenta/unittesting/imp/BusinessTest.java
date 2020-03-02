/*package com.unittest.zenta.unittesting.imp;


import com.unittest.zenta.unittesting.service.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DataServiceStub implements DataService{

    @Override
    public int[] obtenerData() {
        return new int[]{3,1,2};
    }

    @Override
    public int[] calcularData(int valueA,int valueB, int ValueC) {
        return new int[]{valueA,valueB,ValueC};
    }
}

public class BusinessTest {

    @Test
    public void calculateSum(){
        BusinessImp businessImp = new BusinessImp();
        businessImp.setDataService(new DataServiceStub());
        int actualResult = businessImp.calculateSumDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateService(){
        BusinessImp businessImp = new BusinessImp();
        businessImp.setDataService(new DataServiceStub());
        int actualResult = businessImp.calculateSumDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateSumEmpty(){
        BusinessImp businessImp = new BusinessImp();
        businessImp.setDataService(new DataServiceStub());
        int actualResult = businessImp.calculateSumDataServiceValues(0,0,0);
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateMoreValues(){
        BusinessImp businessImp = new BusinessImp();
        businessImp.setDataService(new DataServiceStub());
        int actualResult = businessImp.calculateSumDataServiceValues(1,2,3);
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }
}
*/