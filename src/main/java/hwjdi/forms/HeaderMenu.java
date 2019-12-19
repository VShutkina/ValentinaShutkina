package hwjdi.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class HeaderMenu extends Section {

    @XPath("//ul[contains(@class,'m-l8')]/li")
    private WebList navigationHeaderRootsElements;

    @Css("#user-name")
    private Button loggedUser;

    @XPath("//div[@class='logout']")
    private Button logoutButton;

    public void headerMenuItemClick() {

    }

    public void logout() {
        loggedUser.click();
        logoutButton.click();
    }
}
