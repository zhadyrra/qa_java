package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTestParam {
    String sex;
    boolean expectedHasMane;

    public LionTestParam(String sex, boolean hasMane){
        this.sex = sex;
        this.expectedHasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[] LionsSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void hasManeTest() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(lion.doesHaveMane(), expectedHasMane);
    }
}