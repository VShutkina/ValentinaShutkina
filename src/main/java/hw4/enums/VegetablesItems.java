package hw4.enums;

public enum VegetablesItems {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    ONION("Onion"),
    VEGETABLES("Vegetables");

    final String value;

    VegetablesItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
