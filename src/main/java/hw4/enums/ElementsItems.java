package hw4.enums;

public enum ElementsItems {

    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    WATTER("Watter");

    final String value;

    ElementsItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
