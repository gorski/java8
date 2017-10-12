package net.mgorski.java8.mod01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class AlgorithmsTest {

    @Test
    public void angleTest(){
        Algorithms algorithms = new Algorithms();

        assertEquals(82.5, algorithms.angle(0, 15), 0.);
        assertEquals(0., algorithms.angle(12, 0), 0.);
        assertEquals(7.5, algorithms.angle(3, 15), 0.);

    }
}
