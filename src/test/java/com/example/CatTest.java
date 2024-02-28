package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    Cat catNotMock = new Cat(feline);
    @Test
    public void getSoundTest() {
        assertEquals("Мяу", catNotMock.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        assertArrayEquals(List.of("Животные", "Птицы", "Рыба").toArray(), (new Cat(feline)).getFood().toArray());
    }
}