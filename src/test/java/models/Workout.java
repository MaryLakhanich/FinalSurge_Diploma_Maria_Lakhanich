package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import enums.FeelingWhileTraining;
import enums.PerceivedEffort;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workout {
    private String date;
    private String timeOfDay;
    private String workoutName;
    private String workoutDescription;
    private String duration;
    private FeelingWhileTraining feelingWhileTraining;
    private PerceivedEffort perceivedEffort;
}
