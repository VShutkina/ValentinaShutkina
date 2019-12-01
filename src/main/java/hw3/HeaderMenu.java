package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu {

    protected WebDriver driver;

    @FindBy(xpath = "//nav[@role='navigation']//ul//li")
    private List<WebElement> navigationHeaderAllElements;

    @FindBy(xpath = "//ul[contains(@class,'m-l8')]/li")
    private List<WebElement> navigationHeaderRootsElements;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//li//a")
    private List<WebElement> serviceListSubItems;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getHeaderMenuItemsText() {
        List<String> headerMenuItemsTexts = new ArrayList<>();
        for (WebElement menuHeaderItem : navigationHeaderRootsElements) {
            headerMenuItemsTexts.add(menuHeaderItem.getText());
        }
        return headerMenuItemsTexts;
    }

    public List<String> getHeaderMenuServiceItemsText() {
        List<String> headerMenuServiceItemsTexts = new ArrayList<>();
        for (WebElement serviceItems : serviceListSubItems) {
            headerMenuServiceItemsTexts.add(serviceItems.getText());
        }
        return headerMenuServiceItemsTexts;
    }

    public void headerMenuItemClick(String menuItemName) {
        for (WebElement menuHeaderItem : navigationHeaderAllElements) {
            if (menuItemName.equals(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }

    public void headerSubMenuItemClick(String subMenuItemName) {
        for (WebElement subMenuItem : serviceListSubItems) {
            if (subMenuItemName.equals(subMenuItem.getText())) {
                subMenuItem.click();
                break;
            }
        }
    }
}
