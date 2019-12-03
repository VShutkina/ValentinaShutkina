package hw4.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LeftSide {

    @FindBy(id = "mCSB_1")
    private SelenideElement leftSide;

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li/a/span")
    private ElementsCollection leftPanelMenuItems;

    @FindBy(xpath = "//ul[@class='sub']//li")
    private ElementsCollection leftPanelServiceCollectionSubItems;

    public LeftSide() {
        page(this);
    }

    public SelenideElement getSelenideElementLeftSide() {
        return leftSide;
    }

    public void leftPanelMenuItemsClick(String menuItemName) {
        for (SelenideElement leftPanelMenuItem : leftPanelMenuItems) {
            if (menuItemName.equals(leftPanelMenuItem.getText())) {
                leftPanelMenuItem.click();
                break;
            }
        }
    }

    public ElementsCollection getLeftPanelServiceCollectionSubItems() {
        return leftPanelServiceCollectionSubItems;
    }
}
