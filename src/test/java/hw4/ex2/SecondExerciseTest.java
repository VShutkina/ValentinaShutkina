package hw4.ex2;

import hw4.HomePage;
import hw4.MetalsColorsPage;
import hw4.common.AbstractBaseTest;
import hw4.common.MetalColorPageDataProvider;
import hw4.steps.MetalColorPageActionSteps;
import hw4.steps.MetalColorPageAssertionSteps;
import hw4.testdata.MetalColorPageTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static hw4.enums.HeaderListItems.METALS_AND_COLORS;
import static org.testng.Assert.assertEquals;

public class SecondExerciseTest extends AbstractBaseTest {

    private MetalColorPageActionSteps metalColorPageActionSteps;
    private MetalColorPageAssertionSteps metalColorPageAssertionSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        this.metalColorPageActionSteps = new MetalColorPageActionSteps();
        this.metalColorPageAssertionSteps = new MetalColorPageAssertionSteps();
    }

    @Test(dataProviderClass = MetalColorPageDataProvider.class,
            dataProvider = "TestDataMetalColor")
    public void secondExerciseTest(MetalColorPageTestData testData) {

        // 1. Open test site by URL
        open("https://epam.github.io/JDI/");
        HomePage homePage = metalColorPageActionSteps.homePage();
        MetalsColorsPage metalsColorsPage = metalColorPageActionSteps.metalsColorsPage();


        // 2. Assert Browser title
        assertEquals(homePage.getTitle(), "Home Page");

        //3. Perform login
        homePage.login(testProperties.getProperty("username"), testProperties.getProperty("password"));

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.getUsernameLabelText().shouldHave(text(testProperties.getProperty("expectedUserName")));

        //5. Click on the link on the Header section
        homePage.getHeaderMenu().headerMenuItemClick(METALS_AND_COLORS.getName());

        //6. Fill form on the page
        metalColorPageActionSteps.fillFormOnMetalsColorsPage(metalsColorsPage, testData);

        //7. Click “Submit” button
        metalsColorsPage.clickSubmitButton();

        //8. Check Results block output on the right-side
        metalColorPageAssertionSteps.checkResultOutputs(metalsColorsPage, testData);

        //logout
        metalsColorsPage.getHeaderMenu().logout();

    }
}
