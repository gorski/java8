package net.mgorski.java8.mod04_streams;

import net.mgorski.java8.helpers.ApartmentDto;
import net.mgorski.java8.helpers.CsvLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamsApp {

    private static Logger LOG = LoggerFactory.getLogger(StreamsApp.class);

    public static void main(String[] args) {


        // collect
        List<ApartmentDto> apartments = new CsvLoader().processInputFile("apartments.csv");

        BigDecimal high = new BigDecimal(700000);

        List<String> cities = apartments./*stream().*/parallelStream().filter(d -> {
            return high.compareTo(d.getPrice()) < 0;
        }).sorted(comparing(ApartmentDto::getCity)).map(ApartmentDto::getCity)
                .distinct().collect(toList());

        LOG.info("Collected, distinct cities with high apartment rates:{}", cities);


        // merge
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        LOG.info("Pairs");
        for (int[] pair : pairs) {
            LOG.info("{}x{}", pair[0], pair[1]);
        }

        // reduce to find cheapest apartment
        Optional<ApartmentDto> reduce = apartments.parallelStream().reduce((a, b) -> a.getPrice().compareTo(b.getPrice()) < 0 ? a : b);
        LOG.info("Cheapest (reduce): {}", reduce.orElse(null));

        // reduce just a price
        Optional<BigDecimal> lowest = apartments.parallelStream().map(ApartmentDto::getPrice).reduce(BigDecimal::min);
        LOG.info("Lowest price: {}", lowest.orElse(null));

        // cheapest
        Optional<ApartmentDto> cheapestCompare = apartments.stream().min(comparing(ApartmentDto::getPrice));
        LOG.info("Cheapest (compare): {}", cheapestCompare.orElse(null));

        // streams from functions
        Stream.iterate(0, n -> n + 2)
                .limit(10).forEach(System.out::println);


    }
}
