package utils;

import com.github.javafaker.Faker;
import models.Workout;
import enums.FeelingWhileTraining;
import enums.PerceivedEffort;

public class WorkoutFactory {
    static Faker faker=new Faker();

    public static Workout addStrengthTraining(){
        return Workout.builder()
                .timeOfDay("10:00 AM")
                .workoutName(faker.esports().game())
                .workoutDescription(faker.name().title())
                .duration("1:02:10")
                .feelingWhileTraining(FeelingWhileTraining.GOOD)
                .perceivedEffort(PerceivedEffort.MODERATE6)
                .build();
    }

}
