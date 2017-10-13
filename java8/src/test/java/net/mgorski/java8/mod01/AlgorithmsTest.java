package net.mgorski.java8.mod01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class AlgorithmsTest {

    private static Logger LOG = LoggerFactory.getLogger(AlgorithmsTest.class);
    Algorithms algorithms = new Algorithms();

    @Test
    public void angleTest(){


        assertEquals(82.5, algorithms.angle(0, 15), 0.);
        assertEquals(0., algorithms.angle(12, 0), 0.);
        assertEquals(7.5, algorithms.angle(3, 15), 0.);

    }

    @Test
    public void fibonacci(){
        List<Integer> fibbonacci = algorithms.fibbonacci(40);
        LOG.info("Fibb:{}", fibbonacci);
        assertEquals(0, fibbonacci.get(0),0);
        assertEquals(1, fibbonacci.get(1),0);
        assertEquals(1, fibbonacci.get(2),0);
        assertEquals(2, fibbonacci.get(3),0);
        assertEquals(3, fibbonacci.get(4),0);
        assertEquals(5, fibbonacci.get(5),0);
        assertEquals(40, fibbonacci.size(), 0);
    }
}
