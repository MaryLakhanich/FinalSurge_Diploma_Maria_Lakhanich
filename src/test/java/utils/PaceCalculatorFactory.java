package utils;

import com.github.javafaker.Faker;
import models.PaceCalculator;

public class PaceCalculatorFactory {
    static Faker faker=new Faker();

    public static PaceCalculator getPaceCalculator() {
        return PaceCalculator.builder()
                .distance(faker.number().numberBetween(1,15))
                .hours(faker.number().numberBetween(1,7))
                .minutes(faker.number().numberBetween(1,59))
                .seconds(faker.number().numberBetween(1,59))
                .build();
    }
}
