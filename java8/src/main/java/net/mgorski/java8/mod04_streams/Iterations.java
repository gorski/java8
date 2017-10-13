package net.mgorski.java8.mod04_streams;

import net.mgorski.java8.helpers.ApartmentDto;
import net.mgorski.java8.helpers.CsvLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Iterations {

    private static Logger LOG = LoggerFactory.getLogger(Iterations.class);

    public static void main(String[] args) {

        // external iteration
        List<ApartmentDto> apartments = new CsvLoader().processInputFile("apartments.csv");
        List<ApartmentDto> longList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            longList.addAll(apartments);
        }

        LOG.info("List has {} elements", longList.size());

        long start = System.currentTimeMillis();
        List<Long> externallyCollected = new ArrayList<>();
        for (ApartmentDto apartment : longList) {
            externallyCollected.add(apartment.getId());
        }
        long stop = System.currentTimeMillis();


        // internal iteration
        long start2 = System.currentTimeMillis();
        List<Long> collect = longList.stream().map(ApartmentDto::getId).collect(toList());
        long stop2 = System.currentTimeMillis();

        LOG.info("External:{}ms Internal:{}ms", (stop - start), (stop2 - start2));

    }
}
