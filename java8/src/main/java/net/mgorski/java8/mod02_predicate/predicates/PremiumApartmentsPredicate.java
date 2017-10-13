package net.mgorski.java8.mod02_predicate.predicates;

import net.mgorski.java8.helpers.ApartmentDto;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class PremiumApartmentsPredicate extends ApartmentsAbovePricePredicate implements Predicate<ApartmentDto> {
    final static BigDecimal EXPENSIVE_TRESHOLD = BigDecimal.valueOf(230000);

    public PremiumApartmentsPredicate() {
        super(EXPENSIVE_TRESHOLD);
    }

//    @Override
//    public boolean test(ApartmentDto dto) {
//        return EXPENSIVE_TRESHOLD.compareTo(dto.getPrice()) < 0 ;
//    }

}
