package hw5.ex1;

import hw5.common.AbstractBaseTest;
import hw5.common.AttachmentListener;
import hw5.steps.HomePageActionSteps;
import hw5.steps.HomePageAssertionSteps;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class, AttachmentListener.class})
public class FirstExerciseTest extends AbstractBaseTest {

    private HomePageActionSteps homePageActionSteps;
    private HomePageAssertionSteps homePageAssertionSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageActionSteps = new HomePageActionSteps(driver);
        homePageAssertionSteps = new HomePageAssertionSteps(driver);
    }

    @Test
    public void firstExerciseTest() {

        // 1. Open test site by URL
        homePageActionSteps.openEpamJdiSite();

        // 2. Assert Browser title
        homePageAssertionSteps.pageTitleOnTheHomePageShouldBe("Home Page");

        // 3. Perform login
        homePageActionSteps.login(testProperties.getProperty("username"), testProperties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageAssertionSteps.usernameOnTheHomePageShouldBe(testProperties.getProperty("expectedUserName"));

        // 5. Assert Browser title
        homePageAssertionSteps.pageTitleOnTheHomePageShouldBe("Home Page");

        // 6. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        homePageAssertionSteps.checkThatHeaderListItemsShouldBe();

        // 7. Assert that there are 4 images on the Index Page and they are displayed
        homePageAssertionSteps.checkThatImagesOnTheHomePageAreDisplayed();

        // 8. Assert that there are 4 texts on the Index Page
        // under icons and they have proper text
        homePageAssertionSteps.checkThatTextsIconsOnTheHomePageShouldBe();

        // 9. Assert a text of the main headers
        homePageAssertionSteps.checkThatMainTitleTextOnTheHomePageShouldBe("EPAM FRAMEWORK WISHES…");
        homePageAssertionSteps.checkThatMainTextOnTheHomePageShouldBe("LOREM IPSUM");

        // 10. Assert that there is the iframe in the center of page
        homePageAssertionSteps.checkThatIframeOnTheHomePageShouldBe();

        //11. Switch to the iframe and check that there is Epam logo
        // in the left top conner of iframe
        homePageActionSteps.switchToIframe();
        homePageAssertionSteps.checkThatEpamLogoIsDisplayed();

        //12. Switch to original window back
        homePageActionSteps.switchToOriginalWindow();

        //13. Assert a text of the sub header
        homePageAssertionSteps.checkThatTextInTheSubHeaderShouldBe("JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageAssertionSteps.checkThatLinkUrlSubHeaderShouldBe("https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        homePageAssertionSteps.checkThatLeftPanelIsDisplayed();

        //16. Assert that there is Footer
        homePageAssertionSteps.checkThatFooterIsDisplayed();

    }
}
