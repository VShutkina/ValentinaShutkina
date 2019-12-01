package hw4.enums;

public enum ShowEntities {

    FIVE("5"),
    TEN("10"),
    FIFTEEN("15"),
    TWENTY("20");

    final String value;

    ShowEntities(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer getIntValue() {
        return Integer.parseInt(value);
    }
}
