package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unums.FeelingWhileTraining;
import unums.PerceivedEffort;

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
