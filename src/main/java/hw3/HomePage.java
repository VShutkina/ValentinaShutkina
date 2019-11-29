package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/";

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernamelabel;

    @FindBy(xpath = "//ul[contains(@class,'m-l8')]/li")
    private WebElement headerListItems;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void login(final String username, final String password) {
        userIcon.click();
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public String getUsernameLabelText() {
        return usernamelabel.getText();
    }
}
