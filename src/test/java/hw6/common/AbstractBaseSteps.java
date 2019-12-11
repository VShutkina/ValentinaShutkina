package hw6.common;

import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;

public abstract class AbstractBaseSteps {

    protected static HomePage homePage;
    protected static DifferentElementsPage differentElementsPage;
    protected static UserTablePage userTablePage;

    public AbstractBaseSteps() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    }
}
