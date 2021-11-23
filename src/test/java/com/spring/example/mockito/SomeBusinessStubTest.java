package com.spring.example.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessStubTest {

    @Test
    void find_the_greatest_from_all_data() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(new DataServiceStub());
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(15, result);
    }

    class DataServiceStub implements DataService {

        @Override
        public int[] retrieveAllData() {
            return new int[] {4, 6, 15};
        }
    }

}