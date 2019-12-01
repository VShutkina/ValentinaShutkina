package hw3.steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPageAssertionSteps extends AbstractSteps {

    SoftAssert softAssert = new SoftAssert();

    public DifferentElementsPageAssertionSteps(WebDriver driver) {
        super(driver);
    }

    public void checkDefaultButtonIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    public void checkButtonIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    public void checkDropdownIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    public void checkCheckboxAreDisplayed() {
        differentElementsPage.getCheckBoxList().forEach(t -> softAssert.assertTrue(t.isDisplayed()));
    }

    public void checkRadioButtonsAreDisplayed() {
        differentElementsPage.getRadioButtonsList().forEach(a -> softAssert.assertTrue(a.isDisplayed()));
    }

    public void checkRightSectionIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    public void checkLeftPanelIsDisplayed() {
        softAssert.assertTrue(differentElementsPage.getLeftSide().getWebElementLeftSide().isDisplayed());
    }

    public void checkLastLogRecordText(final String logRecord) {
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains(logRecord));
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
