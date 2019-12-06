package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPageAssertionSteps extends AbstractSteps {

    SoftAssert softAssert = new SoftAssert();

    public DifferentElementsPageAssertionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Default button should be displayed")
    public void checkDefaultButtonIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Step("Button should be existed")
    public void checkButtonIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    @Step("Dropdown should be displayed")
    public void checkDropdownIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    @Step("Checkboxes should be displayed")
    public void checkCheckboxAreDisplayed() {
        differentElementsPage.getCheckBoxList().forEach(t -> softAssert.assertTrue(t.isDisplayed()));
    }

    @Step("Radio buttons should be displayed")
    public void checkRadioButtonsAreDisplayed() {
        differentElementsPage.getRadioButtonsList().forEach(a -> softAssert.assertTrue(a.isDisplayed()));
    }

    @Step("Right Section should be displayed")
    public void checkRightSectionIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Step("Lest Panel should be displayed")
    public void checkLeftPanelIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getLeftSide().getWebElementLeftSide().isDisplayed());
    }

    @Step("Log record {0} should be displayed")
    public void checkLastLogRecordText(final String logRecord) {
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains(logRecord));
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
