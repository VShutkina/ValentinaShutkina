package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.HomePage;
import hw6.common.AbstractBaseSteps;
import hw6.common.WebDriverSingleton;

public class ModalSteps extends AbstractBaseSteps {

    @Given("^I open EPAM JDI Site$")
    public void iOpenEpamJdiSite() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open();
    }
}
