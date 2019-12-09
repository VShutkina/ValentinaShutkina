package hw6.ex2.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.common.AbstractBaseSteps;
import hw6.ex2.TestStorage;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondExerciseAssertionSteps extends AbstractBaseSteps {

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
