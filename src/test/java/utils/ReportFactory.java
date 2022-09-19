package utils;

import enums.ActivityType;
import models.Report;

public class ReportFactory {
    public static Report getReportInform() {
        return Report.builder()
                .startDate("8/28/2022")
                .endDate("9/17/2022")
                .activityType(ActivityType.STRENGTH_TRAINING)
                .build();
    }

}
