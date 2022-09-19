package utils;

import com.github.javafaker.Faker;
import models.CaloricNeedsCalculator;
import models.PaceCalculator;

public class CaloricNeedsCalculatorFactory {
    static Faker faker=new Faker();

    public static CaloricNeedsCalculator getCaloricNeedsCalculator(){
        return CaloricNeedsCalculator.builder()
                .weight(faker.number().numberBetween(50, 90))
                .height(faker.number().numberBetween(150, 200))
                .age(faker.number().numberBetween(18, 50))
                .runDistance(faker.number().numberBetween(5,20))
                .build();
    }
}
