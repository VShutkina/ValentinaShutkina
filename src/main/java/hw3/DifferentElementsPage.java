package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractBasePage {

    @FindBy(name = "Default Button")
    private WebElement defaultButton;

    @FindBy(css = ".uui-button[type=button]")
    private WebElement button;

    @FindBy(css = ".colors")
    private WebElement dropdown;

    @FindBy(xpath = "//label[@class='label-checkbox']")
    private WebElement checkBoxElements;

    @FindBy(xpath = "//label[@class='label-radio']")
    private WebElement radioBtnsElements;

    @FindBy(id = "mCSB_2")
    private WebElement rightSection;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkBoxList;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[1]")
    private WebElement lastLogRecord;

    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radioButtonsList;

    @FindBy(xpath = "//div[@class='colors']//select[@class='uui-form-element']")
    private WebElement colorsSelector;


    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void setCheckBox(String checkBoxName) {
        for (WebElement checkBox : checkBoxList) {
            if (checkBoxName.equals(checkBox.getText())) {
                checkBox.click();
                break;
            }
        }
    }

    public String getLastLogRecordText() {
        return lastLogRecord.getText();
    }

    public void selectRadioButton(String radioButtonName) {
        for (WebElement radioButton : radioButtonsList) {
            if (radioButtonName.equals(radioButton.getText())) {
                radioButton.click();
                break;
            }
        }
    }


    public void selectColor(String color) {
        new Select(colorsSelector).selectByVisibleText(color);
    }

}