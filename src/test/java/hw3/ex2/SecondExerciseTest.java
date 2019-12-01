package hw3.ex2;

import hw3.AbstractBaseTest;
import hw3.DifferentElementsPage;
import hw3.HomePage;
import hw3.enums.HeaderListItems;
import hw3.enums.HeaderServiceItems;
import hw3.enums.LeftSideListItems;
import hw3.enums.LeftSideServiceItems;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondExerciseTest extends AbstractBaseTest {

    @Test
    public void secondExerciseTest() {

        HomePage homePage = new HomePage(driver);

        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        homePage.open();

        // 2. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        // 3. Perform login
        homePage.login(testProperties.getProperty("username"), testProperties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.getUsernameLabelText(), testProperties.getProperty("expectedUserName"));

        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        homePage.getHeaderMenu().headerMenuItemClick(HeaderListItems.SERVICE.name());
        List<String> headerMenuExpectedServiceSubItems = Stream.of(HeaderServiceItems.values())
                .map(HeaderServiceItems::getName)
                .collect(Collectors.toList());
        softAssert.assertEquals(homePage
                        .getHeaderMenu()
                        .getHeaderMenuServiceItemsText(),
                headerMenuExpectedServiceSubItems);
        softAssert.assertAll();

        // 6. Click on Service subcategory in the left section
        // and check that drop down contains options
        homePage.getLeftSide().leftPanelMenuItemsClick(LeftSideListItems.SERVICE_LEFT_PANEL.getValue());
        List<String> leftPanelExpectedServiceSubItems = Stream.of(LeftSideServiceItems.values())
                .map(LeftSideServiceItems::getName)
                .collect(Collectors.toList());
        softAssert.assertEquals(homePage
                        .getLeftSide()
                        .getLeftPanelMenuServiceItemsText(),
                leftPanelExpectedServiceSubItems);
        softAssert.assertAll();

        // 7. Open through the header menu Service -> Different Elements Page
        homePage.getHeaderMenu().headerMenuItemClick(HeaderListItems.SERVICE.getName());
        homePage.getHeaderMenu().headerSubMenuItemClick(HeaderServiceItems.DIFFERENT_ELEMENTS.getName());

        // 8. Check interface on Different elements page,
        // it contains all needed elements
        softAssert.assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
        softAssert.assertTrue(differentElementsPage.getButton().isDisplayed());
        softAssert.assertTrue(differentElementsPage.getDropdown().isDisplayed());
        differentElementsPage.getCheckBoxList().forEach(t -> softAssert.assertTrue(t.isDisplayed()));
        differentElementsPage.getRadioButtonsList().forEach(a -> softAssert.assertTrue(a.isDisplayed()));
        softAssert.assertAll();

        // 9. Assert that there is Right Section
        assertTrue(differentElementsPage.getRightSection().isDisplayed());

        // 10. Assert that there is Left Section
        assertTrue(differentElementsPage.getLeftSide().getWebElementLeftSide().isDisplayed());

        // 11. Select checkboxes
        // 12. Assert that for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox.
        differentElementsPage.setCheckBox("Water");
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains("Water: condition changed to true"));
        differentElementsPage.setCheckBox("Wind");
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains("Wind: condition changed to true"));

        // 13. Select radio
        // 14. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        differentElementsPage.selectRadioButton("Selen");
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains("value changed to Selen"));

        // 15. Select in dropdown
        // 16. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        differentElementsPage.selectColor("Yellow");
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains("Colors: value changed to Yellow"));

        // 17. Unselect and assert checkboxes
        // 18. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        differentElementsPage.setCheckBox("Water");
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains("Water: condition changed to false"));
        differentElementsPage.setCheckBox("Wind");
        softAssert.assertTrue(differentElementsPage.getLastLogRecordText().contains("Wind: condition changed to false"));
        softAssert.assertAll();

    }
}
