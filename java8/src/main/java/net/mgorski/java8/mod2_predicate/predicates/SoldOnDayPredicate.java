package net.mgorski.java8.mod2_predicate.predicates;

import net.mgorski.java8.helpers.ApartmentDto;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * Apartments sold on weekend.
 */
public class SoldOnDayPredicate implements Predicate<ApartmentDto> {

    @Override
    public boolean test(ApartmentDto dto) {
        DayOfWeek dayOfWeek = dto.getSaleDate().getDayOfWeek();
        return DayOfWeek.SATURDAY.equals(dayOfWeek) || DayOfWeek.SUNDAY.equals(dayOfWeek);
    }

}
