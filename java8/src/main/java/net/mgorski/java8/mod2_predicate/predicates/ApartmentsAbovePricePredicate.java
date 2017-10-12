package net.mgorski.java8.mod2_predicate.predicates;

import net.mgorski.java8.helpers.ApartmentDto;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * Apartments above price threshold.
 */
public class ApartmentsAbovePricePredicate implements Predicate<ApartmentDto> {
    final BigDecimal threshold;

    public ApartmentsAbovePricePredicate(BigDecimal threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(ApartmentDto dto) {
        return threshold.compareTo(dto.getPrice()) < 0 ;
    }

}
