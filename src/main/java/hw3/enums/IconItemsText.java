package hw3.enums;

public enum IconItemsText {

    GOOD_PRACTICE("To include good practices and ideas from successful EPAM project"),
    FLEX_CUSTOM("To be flexible and customizable"),
    MULTIPLATFORM("To be multiplatform"),
    MORE("Already have good base (about 20 internal and some external projects), wish to get more…");

    final String text;

    IconItemsText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
