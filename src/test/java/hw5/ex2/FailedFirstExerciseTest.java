package hw5.ex2;

import hw5.common.AbstractBaseTest;
import hw5.common.AttachmentListener;
import hw5.steps.HomePageActionSteps;
import hw5.steps.HomePageAssertionSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Features({@Feature("Failed Home page test case"), @Feature("FailedFirstExercise")})
@Listeners({AttachmentListener.class})
public class FailedFirstExerciseTest extends AbstractBaseTest {

    private HomePageActionSteps homePageActionSteps;
    private HomePageAssertionSteps homePageAssertionSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageActionSteps = new HomePageActionSteps(driver);
        homePageAssertionSteps = new HomePageAssertionSteps(driver);
    }

    @Stories({@Story("Test home page functionality with failed case"),
            @Story("Assert Browser title with incorrect value")})
    @Test
    public void firstExerciseTest() {

        // 1. Open test site by URL
        homePageActionSteps.openEpamJdiSite();

        // 2. Assert Browser title with incorrect value
        homePageAssertionSteps.pageTitleOnTheHomePageShouldBe("Home Page1");

    }
}
