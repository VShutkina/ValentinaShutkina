package hw6.ex2.steps;

import cucumber.api.java.en.Then;
import hw6.common.AbstractBaseSteps;

import static org.testng.Assert.assertEquals;

public class SecondExerciseAssertionSteps extends AbstractBaseSteps {

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(final String pageTitle) {
        assertEquals(userTablePage.getPageTitle(), pageTitle);
    }
}
