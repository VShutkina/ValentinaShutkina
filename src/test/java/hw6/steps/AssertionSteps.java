package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.common.AbstractBaseSteps;
import hw6.common.TestStorage;
import hw6.enums.IconItemsText;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends AbstractBaseSteps {

    @Then("^username should be '([^\"]+)' on the Home page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Then("^pictures should be displayed on the Home page$")
    public void picturesShouldBeDisplayedOnTheHomePage() {
        assertTrue(homePage.getIconPractice().isDisplayed());
        assertTrue(homePage.getIconCustom().isDisplayed());
        assertTrue(homePage.getIconMulti().isDisplayed());
        assertTrue(homePage.getIconBase().isDisplayed());
    }

    @Then("^pictures texts should be displayed on the Home page$")
    public void picturesTextsShouldBeDisplayedOnTheHomePage() {
        List<String> expectedTextIconItems = Stream.of(IconItemsText.values())
                .map(IconItemsText::getText)
                .collect(Collectors.toList());
        assertEquals(homePage.getTextIconItems(), expectedTextIconItems);
    }

    @Then("^headline should be '([^\"]+)' on the Home page$")
    public void headlineShouldBeDisplayedOnTheHomePage(final String mainTitleText) {
        assertEquals(homePage.getMainTitleText(), mainTitleText);
    }

    @Then("^description should start with '([^\"]+)' on the Home page$")
    public void descriptionShouldBeDisplayedOnTheHomePage(final String mainText) {
        assertTrue(homePage.getMainText().startsWith(mainText));
    }

    @Then("^Service drop down should contain in the header$")
    public void serviceDropDownShouldContainInTheHeader(List<String> headerMenuExpectedServiceSubItems) {
        assertTrue(homePage
                .getHeaderMenu()
                .getHeaderMenuServiceItemsText().containsAll(headerMenuExpectedServiceSubItems));

    }

    @Then("^Service drop down should contain in the left section$")
    public void serviceDropDownShouldContainInTheLeftSection(List<String> expectedLeftSectionServiceDropDown) {
        assertTrue(homePage
                .getLeftSide()
                .getLeftPanelMenuServiceItemsText().containsAll(expectedLeftSectionServiceDropDown));
    }

    @Then("^checkboxes should be displayed on the Different Elements page$")
    public void checkboxesShouldBeDisplayedOnTheDifferentElementsPage() {
        differentElementsPage.getCheckBoxList().forEach(t -> assertTrue(t.isDisplayed()));
    }

    @Then("^radio buttons should be displayed on the Different Elements page$")
    public void radioButtonsShouldBeDisplayedOnTheDifferentElementsPage() {
        differentElementsPage.getRadioButtonsList().forEach(a -> assertTrue(a.isDisplayed()));
    }

    @Then("^dropdown should be displayed on the Different Elements page$")
    public void dropdownShouldBeDisplayedOnTheDifferentElementsPage() {
        assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    @Then("^button should be displayed on the Different Elements page$")
    public void buttonShouldBeDisplayedOnTheDifferentElementsPage() {
        assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    @Then("^default button should be displayed on the Different Elements page$")
    public void defaultButtonShouldBeDisplayedOnTheDifferentElementsPage() {
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Then("^Right Section should be displayed on the Different Elements page$")
    public void rightSectionShouldBeDisplayedOnTheDifferentElementsPage() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());

    }

    @Then("^Left Section should be displayed on the Different Elements page$")
    public void leftSectionShouldBeDisplayedOnTheDifferentElementsPage() {
        assertTrue(differentElementsPage.getLeftSide().getWebElementLeftSide().isDisplayed());
    }

    @Then("^log row should be '([^\"]+)' on the Different Elements page$")
    public void logRowShouldBeDisplayedOnTheDifferentElementsPage(final String logRecord) {
        assertTrue(differentElementsPage.getLastLogRecordText().contains(logRecord));
    }

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(final String pageTitle) {
        assertEquals(userTablePage.getPageTitle(), pageTitle);
    }

    @Then("^6 NumberType Dropdowns should be displayed on Users Table on User Table Page$")
    public void numbersTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage() {
        userTablePage.getNumberTypeDropdowns().forEach(t -> assertTrue(t.isDisplayed()));
    }

    @Then("^6 User names should be displayed on Users Table on User Table Page$")
    public void useNamesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        userTablePage.getUserNamesList().forEach(t -> t.isDisplayed());
    }

    @Then("^6 Description images should be displayed on Users Table on User Table Page$")
    public void descriptionImagesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        userTablePage.getDescriptionImages().forEach(t -> t.isDisplayed());

    }

    @Then("^6 Description texts under images should be displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        userTablePage.getDescriptionText().forEach(t -> t.isDisplayed());
    }

    @Then("^6 checkboxes should be displayed on Users Table on User Table Page$")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        userTablePage.getCheckboxes().forEach(t -> t.isDisplayed());

    }

    @Then("^User table should contain following values:$")
    public void userTableShouldContainFollowingValues(DataTable table) {
        SoftAssert sa = new SoftAssert();
        List<Map<String, String>> values = table.asMaps(String.class, String.class);

        values.forEach(t -> sa.assertTrue(
                userTablePage.getUserNumberListText().contains(t.get("Number")),
                "User Table numbers checker"
        ));
        values.forEach(t -> sa.assertTrue(
                userTablePage.getUserNamesText().contains(t.get("User")),
                "User Table userNames checker"
        ));
        values.forEach(t -> sa.assertTrue(
                userTablePage.getUserDescriptionText().contains(t.get("Description")),
                "User Table userDescriptions checker"
        ));
        sa.assertAll();
    }

    @Then("^log row '([^\"]+)' text should be displayed in log section$")
    public void logRowTextShouldBeDisplayedInLogSection(final String logRecord) {
        assertTrue(userTablePage.getUserTableLogRecordText().contains(logRecord));
    }

    @Then("^dropdown list should contain values$")
    public void dropdownListShouldContainValues(List<String> expectedOptionsList) {
        assertTrue(expectedOptionsList.containsAll(TestStorage.INSTANCE.getOptionsList()));
    }
}
