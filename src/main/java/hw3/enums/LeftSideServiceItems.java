package hw3.enums;

public enum LeftSideServiceItems {

    SUPPORT_LEFT_PANEL("Support"),
    DATES_LEFT_PANEL("Dates"),
    COMPLEX_TABLE_LEFT_PANEL("Complex Table"),
    SIMPLE_TABLE_LEFT_PANEL("Simple Table"),
    SEARCH_LEFT_PANEL("Search"),
    USER_TABLE_LEFT_PANEL("User Table"),
    TABLE_WITH_PAGES_LEFT_PANEL("Table with pages"),
    DIFFERENT_ELEMENTS_LEFT_PANEL("Different elements"),
    PERFORMANCE_LEFT_PANEL("Performance");

    final String name;

    LeftSideServiceItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
