package hwjdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hwjdi.entities.JdiUser;
import hwjdi.forms.LoginForm;

public class HomePage extends WebPage {

    private LoginForm loginForm;

    @Css("#user-icon")
    private Button userIcon;

    @Css("#user-name")
    private Text userName;

    public void login(JdiUser jdiUser) {
        userIcon.click();
        loginForm.login(jdiUser);
    }

    public String getUserName() {
        return userName.getText();
    }
}
