package hw3.ex1;

import hw3.AbstractBaseTest;
import hw3.HomePage;
import hw3.enums.HeaderListItems;
import hw3.enums.IconItemsText;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstExerciseTest extends AbstractBaseTest {

    @Test
    public void firstExerciseTest() {
        HomePage homePage = new HomePage(driver);

        // 1. Open test site by URL
        homePage.open();

        // 2. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        // 3. Perform login
        homePage.login(testProperties.getProperty("username"), testProperties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.getUsernameLabelText(), testProperties.getProperty("expectedUserName"));

        // 5. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        // 6. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<String> expectedHeaderListItems = Stream.of(HeaderListItems.values())
                .map(HeaderListItems::getName)
                .collect(Collectors.toList());
        assertEquals(homePage.getHeaderMenu().getHeaderMenuItemsText(), expectedHeaderListItems);

        // 7. Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(homePage.getIconPractice().isDisplayed());
        assertTrue(homePage.getIconCustom().isDisplayed());
        assertTrue(homePage.getIconMulti().isDisplayed());
        assertTrue(homePage.getIconBase().isDisplayed());

        // 8. Assert that there are 4 texts on the Index Page
        // under icons and they have proper text
        List<String> expectedTextIconItems = Stream.of(IconItemsText.values())
                .map(IconItemsText::getText)
                .collect(Collectors.toList());
        assertEquals(homePage.getTextIconItems(), expectedTextIconItems);

        // 9. Assert a text of the main headers
        assertEquals(homePage.getMainTitleText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(homePage.getMainText().contains("LOREM IPSUM"));

        // 10. Assert that there is the iframe in the center of page
        assertTrue(homePage.getIframe().isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo
        // in the left top conner of iframe
        homePage.switchToIframe();
        assertTrue(homePage.getEpamLogo().isDisplayed());

        //12. Switch to original window back
        homePage.switchToOriginalWindow();

        //13. Assert a text of the sub header
        assertEquals(homePage.getSubHeaderLinkText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(homePage.getSubHeaderLinkUrl(), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        assertTrue(homePage.getLeftSide().getWebElementLeftSide().isDisplayed());

        //16. Assert that there is Footer
        assertTrue(homePage.getFooter().getWebElementFooter().isDisplayed());

    }
}
