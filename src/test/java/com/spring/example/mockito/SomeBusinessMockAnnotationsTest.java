package com.spring.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockAnnotationsTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl someBusiness;


    @Test
    void find_the_greatest_from_all_data() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {4, 12,15});
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(15, result);
    }

    @Test
    void find_the_greatest_from_one_value() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(15, result);
    }

    @Test
    void find_the_greatest_from_no_value() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE, result);
    }
}