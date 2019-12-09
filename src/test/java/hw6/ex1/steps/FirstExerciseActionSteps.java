package hw6.ex1.steps;

import cucumber.api.java.en.When;
import hw6.common.AbstractBaseSteps;

public class FirstExerciseActionSteps extends AbstractBaseSteps {

    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on the Home page$")
    public void iLoginAsUserWithPasswordOnTheHomePage(String username, String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.loginButtonClick();
    }

    @When("^I click on '([^\"]+)' subcategory in the header on the Home page$")
    public void iClickOnSubcategoryInTheHeaderOnTheHomePage(final String headerMenuItem) {
        homePage.getHeaderMenu().headerMenuItemClick(headerMenuItem);
    }

    @When("^I click on '([^\"]+)' subcategory in the left section on the Home page$")
    public void iClickOnSubcategoryInTheLeftSectionOnTheHomePage(final String headerSubMenuItem) {
        homePage.getLeftSide().leftPanelMenuItemsClick(headerSubMenuItem);
    }

    @When("^I click on '([^\"]+)' in the Service sub menu on the Home Page$")
    public void iClickOnServiceSubMenuOnTheHomePage(final String headerSubMenuItem) {
        homePage.getHeaderMenu().headerSubMenuItemClick(headerSubMenuItem);
    }

    @When("^I select '([^\"]+)' checkboxes on the Different Elements page$")
    public void iSelectCheckboxesOnTheDifferentElementsPage(final String checkBoxName) {
        differentElementsPage.setCheckBox(checkBoxName);
    }

    @When("^I select '([^\"]+)' radio button on the Different Elements page$")
    public void iSelectRadioButtonOnTheDifferentElementsPage(final String radioButton) {
        differentElementsPage.selectRadioButton(radioButton);
    }

    @When("^I select '([^\"]+)' value in dropdown on the Different Elements page$")
    public void iSelectValueInDropdownOnTheDifferentElementsPage(final String color) {
        differentElementsPage.selectColor(color);
    }

}
