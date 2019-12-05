package hw5.steps;

import org.openqa.selenium.WebDriver;

public class HomePageActionSteps extends AbstractSteps {

    public HomePageActionSteps(WebDriver driver) {
        super(driver);
    }

    public void openEpamJdiSite() {
        homePage.open();
    }

    public void login(final String username, final String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.loginButtonClick();
    }

    public void switchToIframe() {
        homePage.switchToIframe();
    }

    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    public void clickHeaderMenuItem(final String headerMenuItem) {
        homePage.getHeaderMenu().headerMenuItemClick(headerMenuItem);
    }

    public void clickLeftSideMenuItem(final String leftSideMenuItem) {
        homePage.getLeftSide().leftPanelMenuItemsClick(leftSideMenuItem);
    }

    public void clickHeaderSubMenuItem(final String headerSubMenuItem) {
        homePage.getHeaderMenu().headerSubMenuItemClick(headerSubMenuItem);
    }


}
