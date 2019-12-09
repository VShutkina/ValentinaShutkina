package hw6.ex2.steps;

import cucumber.api.java.en.When;
import hw6.common.AbstractBaseSteps;
import hw6.ex2.TestStorage;

public class SecondExerciseActionSteps extends AbstractBaseSteps {

    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on the Home page$")
    public void iLoginAsUserWithPasswordOnTheHomePage(String username, String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.loginButtonClick();
    }

    @When("^I click on '([^\"]+)' button in the header on the Home page$")
    public void iClickOnButtonInTheHeaderOnTheHomePage(final String headerMenuItem) {
        homePage.getHeaderMenu().headerMenuItemClick(headerMenuItem);
    }

    @When("^I click on '([^\"]+)' submenu in Service dropdown on the Home page$")
    public void iClickOnServiceSubMenuOnTheHomePage(final String headerSubMenuItem) {
        homePage.getHeaderMenu().headerSubMenuItemClick(headerSubMenuItem);
    }

    @When("^I select 'vip' checkbox for '([^\"]+)' user$")
    public void iSelectCheckboxForUser(String username) {
        userTablePage.setCheckBoxByUserName(username);
    }

    @When("^I click on dropdown in column Type for user '([^\"]+)'$")
    public void iClickOnDropdownInColumnTypeForUser(String username) {
        TestStorage.INSTANCE.setOptionsList(
                userTablePage.clickDropDownByUserName(username)
        );
    }
}
