package hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/";

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement userNameTextField;

    @FindBy(id = "password")
    private SelenideElement passwordTextField;

    @FindBy(id = "login-button")
    private SelenideElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement usernamelabel;

    public HomePage() {
        page(this);
    }

    public String getTitle() {
        return Selenide.title();
    }

    public void login(final String username, final String password) {
        userIcon.click();
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public SelenideElement getUsernameLabelText() {
        return usernamelabel;
    }
}
