package hwjdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hwjdi.entities.JdiUser;
import hwjdi.forms.HeaderMenu;
import hwjdi.pages.HomePage;
import hwjdi.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static HomePage homePage;

    @Url("metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;

    public static HeaderMenu headerMenu;

    public static void open() {
        homePage.open();
    }

    public static void login(JdiUser jdiUser) {
        homePage.login(jdiUser);
    }

    public static void openPageInHeaderMenu(String menuItemName) {
        headerMenu.headerMenuItemClick(menuItemName);
    }

    public static void logout() {
        headerMenu.logout();
    }


}
