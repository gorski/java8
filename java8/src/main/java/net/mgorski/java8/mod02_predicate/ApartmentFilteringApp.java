package net.mgorski.java8.mod02_predicate;

import net.mgorski.java8.helpers.ApartmentDto;
import net.mgorski.java8.helpers.CsvLoader;
import net.mgorski.java8.mod02_predicate.predicates.ApartmentsAbovePricePredicate;
import net.mgorski.java8.mod02_predicate.predicates.SoldOnDayPredicate;
import net.mgorski.java8.mod02_predicate.predicates.PremiumApartmentsPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class ApartmentFilteringApp {

    private static Logger LOG = LoggerFactory.getLogger(ApartmentFilteringApp.class);

    public static void main(String[] args) {

        List<ApartmentDto> processInputFile = new CsvLoader().processInputFile("apartments.csv");

        //ApartmentDto[] expensiveApartments = processInputFile.stream().filter(new PremiumApartmentsPredicate()).toArray(ApartmentDto[]::new);

        System.out.println("Expensive -");
        processInputFile.stream().filter(new PremiumApartmentsPredicate()).forEach(System.out::println);

        //sort with lambda expression
        Optional<ApartmentDto> first = processInputFile.stream().sorted((o1, o2) -> {
            return o2.getPrice().compareTo(o1.getPrice());
        }).findFirst();
        first.ifPresent(apartmentDto -> LOG.info("Most expensive: {}", apartmentDto.getPrice()));

        Double percent = 90.;
        BigDecimal treshold = first.isPresent() ? first.get().getPrice().multiply(new BigDecimal(percent / 100)) : new BigDecimal(600000);
        ApartmentsAbovePricePredicate pricePredicate = new ApartmentsAbovePricePredicate(treshold);
        long countIn95percent = processInputFile.stream().filter(pricePredicate).count();

        LOG.info("In {}% of most expensive apartments there are {} offers", percent, countIn95percent);

        LOG.info("Number of apartments sold during the weekend: {}", processInputFile.stream().filter(new SoldOnDayPredicate()).count());


        // other predicate
//        Predicate<String> predicate = (s) -> s.length() > 0;
//
//        predicate.test("foo");              // true
//        predicate.negate().test("foo");     // false
//
//        Predicate<Boolean> nonNull = Objects::nonNull;
//        Predicate<Boolean> isNull = Objects::isNull;
//
//        Predicate<String> isEmpty = String::isEmpty;
//        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
