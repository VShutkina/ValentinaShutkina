package hw4.enums;

public enum MetalsItems {

    SELEN("Selen"),
    BRONZE("Bronze"),
    GOLD("Gold");

    final String value;

    MetalsItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
