package hwjdi.enums;

public enum HeaderListItems {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");


    final String name;

    HeaderListItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
