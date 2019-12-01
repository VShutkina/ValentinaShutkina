package hw3.ex2;

import hw3.common.AbstractBaseTest;
import hw3.enums.HeaderListItems;
import hw3.enums.HeaderServiceItems;
import hw3.enums.LeftSideListItems;
import hw3.steps.DifferentElementsPageActionSteps;
import hw3.steps.DifferentElementsPageAssertionSteps;
import hw3.steps.HomePageActionSteps;
import hw3.steps.HomePageAssertionSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondExerciseTest extends AbstractBaseTest {

    private HomePageActionSteps homePageActionSteps;
    private HomePageAssertionSteps homePageAssertionSteps;
    private DifferentElementsPageActionSteps differentElementsPageActionSteps;
    private DifferentElementsPageAssertionSteps differentElementsPageAssertionSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageActionSteps = new HomePageActionSteps(driver);
        homePageAssertionSteps = new HomePageAssertionSteps(driver);
        differentElementsPageActionSteps = new DifferentElementsPageActionSteps(driver);
        differentElementsPageAssertionSteps = new DifferentElementsPageAssertionSteps(driver);
    }

    @Test
    public void secondExerciseTest() {

        // 1. Open test site by URL
        homePageActionSteps.openEpamJdiSite();

        // 2. Assert Browser title
        homePageAssertionSteps.pageTitleOnTheHomePageShouldBe("Home Page");

        // 3. Perform login
        homePageActionSteps.login(testProperties.getProperty("username"), testProperties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageAssertionSteps.usernameOnTheHomePageShouldBe(testProperties.getProperty("expectedUserName"));

        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        homePageActionSteps.clickHeaderMenuItem(HeaderListItems.SERVICE.getName());
        homePageAssertionSteps.checkHeaderMenuServiceItems();

        // 6. Click on Service subcategory in the left section
        // and check that drop down contains options
        homePageActionSteps.clickLeftSideMenuItem(LeftSideListItems.SERVICE_LEFT_PANEL.getValue());
        homePageAssertionSteps.checkLeftSideServiceItems();

        // 7. Open through the header menu Service -> Different Elements Page
        homePageActionSteps.clickHeaderMenuItem(HeaderListItems.SERVICE.getName());
        homePageActionSteps.clickHeaderSubMenuItem(HeaderServiceItems.DIFFERENT_ELEMENTS.getName());

        // 8. Check interface on Different elements page,
        // it contains all needed elements
        differentElementsPageAssertionSteps.checkDefaultButtonIsDisplayed();
        differentElementsPageAssertionSteps.checkButtonIsDisplayed();
        differentElementsPageAssertionSteps.checkDropdownIsDisplayed();
        differentElementsPageAssertionSteps.checkCheckboxAreDisplayed();
        differentElementsPageAssertionSteps.checkRadioButtonsAreDisplayed();

        // 9. Assert that there is Right Section
        differentElementsPageAssertionSteps.checkRightSectionIsDisplayed();

        // 10. Assert that there is Left Section
        differentElementsPageAssertionSteps.checkLeftPanelIsDisplayed();

        // 11. Select checkboxes
        // 12. Assert that for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox.
        differentElementsPageActionSteps.setCheckBox("Water");
        differentElementsPageAssertionSteps.checkLastLogRecordText("Water: condition changed to true");
        differentElementsPageActionSteps.setCheckBox("Wind");
        differentElementsPageAssertionSteps.checkLastLogRecordText("Wind: condition changed to true");

        // 13. Select radio
        // 14. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        differentElementsPageActionSteps.selectRadioButton("Selen");
        differentElementsPageAssertionSteps.checkLastLogRecordText("value changed to Selen");

        // 15. Select in dropdown
        // 16. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        differentElementsPageActionSteps.selectColor("Yellow");
        differentElementsPageAssertionSteps.checkLastLogRecordText("Colors: value changed to Yellow");

        // 17. Unselect and assert checkboxes
        // 18. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        differentElementsPageActionSteps.setCheckBox("Water");
        differentElementsPageAssertionSteps.checkLastLogRecordText("Water: condition changed to false");
        differentElementsPageActionSteps.setCheckBox("Wind");
        differentElementsPageAssertionSteps.checkLastLogRecordText("Wind: condition changed to false");
        differentElementsPageAssertionSteps.assertAll();

    }
}
