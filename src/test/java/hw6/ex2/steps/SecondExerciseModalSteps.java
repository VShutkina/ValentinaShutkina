package hw6.ex2.steps;

import cucumber.api.java.en.Given;
import hw6.HomePage;
import hw6.common.AbstractBaseSteps;
import hw6.common.WebDriverSingleton;

public class SecondExerciseModalSteps extends AbstractBaseSteps {

    @Given("^I am on Home Page$")
    public void iAmOnHomePage() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open();
    }
}
