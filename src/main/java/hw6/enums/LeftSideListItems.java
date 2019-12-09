package hw6.enums;

public enum LeftSideListItems {

    HOME_LEFT_PANEL("Home"),
    CONTACT_FORM_LEFT_PANEL("Contact form"),
    SERVICE_LEFT_PANEL("Service"),
    METALS_AND_COLORS_LEFT_PANEL("Metals & Colors"),
    ELEMENTS_PACKS_LEFT_PANEL("Elements packs");


    final String value;

    LeftSideListItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
