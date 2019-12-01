package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {

    protected WebDriver driver;

    @FindBy(css = ".footer-content")
    private WebElement footer;

    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWebElementFooter() {
        return this.footer;
    }
}
