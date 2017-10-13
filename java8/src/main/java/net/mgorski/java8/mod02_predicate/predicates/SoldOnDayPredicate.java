package net.mgorski.java8.mod02_predicate.predicates;

import net.mgorski.java8.helpers.ApartmentDto;

import java.time.DayOfWeek;
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
