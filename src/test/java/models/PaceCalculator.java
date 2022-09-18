package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaceCalculator {
    private int distance;
    private int hours;
    private int minutes;
    private int seconds;
}
