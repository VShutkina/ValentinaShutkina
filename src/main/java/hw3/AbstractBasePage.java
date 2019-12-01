package hw3;

import hw3.components.Footer;
import hw3.components.HeaderMenu;
import hw3.components.LeftSide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractBasePage {

    protected WebDriver driver;

    private HeaderMenu headerMenu;
    private Footer footer;
    private LeftSide leftSide;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
        footer = new Footer(driver);
        leftSide = new LeftSide(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public Footer getFooter() {
        return this.footer;
    }

    public LeftSide getLeftSide() {
        return leftSide;
    }

    public WebElement getEpamLogo() {
        return this.epamLogo;
    }
}
