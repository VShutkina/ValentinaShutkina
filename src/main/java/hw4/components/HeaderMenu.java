package hw4.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class HeaderMenu {

    @FindBy(xpath = "//nav[@role='navigation']//ul//li")
    private List<SelenideElement> navigationHeaderAllElements;

    @FindBy(xpath = "//ul[contains(@class,'m-l8')]/li")
    private List<SelenideElement> navigationHeaderRootsElements;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//li//a")
    private ElementsCollection serviceCollectiomSubItems;

    @FindBy(xpath = "//div[@class='logout']")
    private SelenideElement logoutButton;

    @FindBy(id = "user-name")
    private SelenideElement loggedUser;

    public HeaderMenu() {
        page(this);
    }

    public void headerMenuItemClick(String menuItemName) {
        for (SelenideElement menuHeaderItem : navigationHeaderRootsElements) {
            if (menuItemName.equals(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }

    public void headerSubMenuItemClick(String subMenuItemName) {
        for (SelenideElement subMenuItem : serviceCollectiomSubItems) {
            if (subMenuItemName.equals(subMenuItem.getText())) {
                subMenuItem.click();
                break;
            }
        }
    }

    public ElementsCollection getServiceCollectiomSubItems() {
        return serviceCollectiomSubItems;
    }

    public void logout() {
        loggedUser.click();
        logoutButton.click();
    }
}
