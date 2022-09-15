package enums;

public enum DistanceType {
    MILES("m"),
    KILOMETERS("k");

    private final String value;

    DistanceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
