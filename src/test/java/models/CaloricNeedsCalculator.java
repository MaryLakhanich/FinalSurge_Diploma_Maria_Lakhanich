package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaloricNeedsCalculator {
    private int weight;
    private int height;
    private int age;
    private int runDistance;
}
