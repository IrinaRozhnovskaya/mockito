package com.spring.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeListTest {

    @Mock
    List listMock;

    @Test
    void test_size() {
        when(listMock.size()).thenReturn(10);
        assertEquals(10, listMock.size());
    }

    @Test
    void test_size_multiple_returns() {
        when(listMock.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
        assertEquals(20, listMock.size());
    }

    @Test
    void test_get_specific_parameter() {
        when(listMock.get(0)).thenReturn("Some String");
        assertEquals("Some String", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    void test_get_generic_parameter() {
        when(listMock.get(Mockito.anyInt())).thenReturn("Some String");
        assertEquals("Some String", listMock.get(0));
        assertEquals("Some String", listMock.get(1));
    }
}
