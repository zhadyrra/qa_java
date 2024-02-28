package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTestBase {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest(){
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected,actual);
    }

    @Test
    public void lionTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("somegender");
            lion.doesHaveMane();
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}