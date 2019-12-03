package hw4.enums;

public enum ColorsItems {

    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue");

    final String value;

    ColorsItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
