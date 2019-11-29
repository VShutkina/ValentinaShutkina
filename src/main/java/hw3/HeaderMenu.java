package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    protected WebDriver driver;

    @FindBy(xpath = "//nav[@role='navigation']//ul//li")
    private List<WebElement> navigationHeader;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void headerMenuItemClick(String menuItemName) {
        for (WebElement menuHeaderItem : navigationHeader) {
            if (menuItemName.equals(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }
}
