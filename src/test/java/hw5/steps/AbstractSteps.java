package hw5.steps;

import hw3.DifferentElementsPage;
import hw3.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

    protected HomePage homePage;

    protected DifferentElementsPage differentElementsPage;

    public AbstractSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.differentElementsPage = new DifferentElementsPage(driver);
    }
}
