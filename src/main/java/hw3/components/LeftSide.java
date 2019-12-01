package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LeftSide {

    protected WebDriver driver;

    @FindBy(id = "mCSB_1")
    private WebElement leftSide;

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li/a/span")
    private List<WebElement> leftPanelMenuItems;

    @FindBy(xpath = "//ul[@class='sub']//li")
    private List<WebElement> leftPanelServiceListSubItems;

    public LeftSide(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWebElementLeftSide() {
        return this.leftSide;
    }

    public void leftPanelMenuItemsClick(String menuItemName) {
        for (WebElement leftPanelMenuItem : leftPanelMenuItems) {
            if (menuItemName.equals(leftPanelMenuItem.getText())) {
                leftPanelMenuItem.click();
                break;
            }
        }
    }

    public List<String> getLeftPanelMenuServiceItemsText() {
        List<String> leftPanelServiceItemsTexts = new ArrayList<>();
        for (WebElement serviceItems : leftPanelServiceListSubItems) {
            leftPanelServiceItemsTexts.add(serviceItems.getText());
        }
        return leftPanelServiceItemsTexts;
    }
}
