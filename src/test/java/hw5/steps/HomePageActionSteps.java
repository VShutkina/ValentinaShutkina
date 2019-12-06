package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageActionSteps extends AbstractSteps {

    public HomePageActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("I open EPAM Jdi Site")
    public void openEpamJdiSite() {
        homePage.open();
    }

    @Step("I login as '{0}' with password '{1}'")
    public void login(final String username, final String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.loginButtonClick();
    }

    @Step("I switch to iframe")
    public void switchToIframe() {
        homePage.switchToIframe();
    }

    @Step("I switch to main window")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("I click on Header menu item {0}")
    public void clickHeaderMenuItem(final String headerMenuItem) {
        homePage.getHeaderMenu().headerMenuItemClick(headerMenuItem);
    }

    @Step("I click on {0} Menu Item in Lest Side")
    public void clickLeftSideMenuItem(final String leftSideMenuItem) {
        homePage.getLeftSide().leftPanelMenuItemsClick(leftSideMenuItem);
    }

    @Step("I click on {0} Header Menu Sub Item")
    public void clickHeaderSubMenuItem(final String headerSubMenuItem) {
        homePage.getHeaderMenu().headerSubMenuItemClick(headerSubMenuItem);
    }


}
