package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(css = ".icon-practise")
    private WebElement iconPractice;

    @FindBy(css = ".icon-custom")
    private WebElement iconCustom;

    @FindBy(css = ".icon-multi")
    private WebElement iconMulti;

    @FindBy(css = ".icon-base")
    private WebElement iconBase;

    @FindBy(id = "iframe")
    private WebElement iframe;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement subHeaderLink;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textIconItems;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void setTextUsernameTextField(final String username) {
        userNameTextField.sendKeys(username);
    }

    public void setTextPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public String getUsernameLabelText() {
        return usernamelabel.getText();
    }

    public WebElement getIconPractice() {
        return this.iconPractice;
    }

    public WebElement getIconCustom() {
        return this.iconCustom;
    }

    public WebElement getIconMulti() {
        return this.iconMulti;
    }

    public WebElement getIconBase() {
        return this.iconBase;
    }

    public WebElement getIframe() {
        return this.iframe;
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public String getSubHeaderLinkText() {
        return subHeaderLink.getText();
    }

    public String getSubHeaderLinkUrl() {
        return subHeaderLink.getAttribute("href");
    }

    public String getMainTitleText() {
        return mainTitle.getText();
    }

    public String getMainText() {
        return mainText.getText();
    }

    public List<String> getTextIconItems() {
        List<String> iconItemsText = new ArrayList<>();
        for (WebElement textIconItem : textIconItems) {
            iconItemsText.add(textIconItem.getText().replaceAll("\n", " "));
        }
        return iconItemsText;
    }
}
