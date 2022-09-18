package utils;

import models.PrintDate;

public class PrintDateFactory {
    public static PrintDate getPrintDate(){
        return PrintDate.builder()
                .printStartingDate("8/28/2022")
                .printEndingDate("9/10/2022")
                .build();
    }
}
