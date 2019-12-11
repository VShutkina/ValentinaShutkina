package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends AbstractBasePage {

    @FindBy(css = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "tr>td:nth-child(1)")
    private List<WebElement> userNumberList;

    @FindBy(css = "tr>td:nth-child(3)>a")
    private List<WebElement> userNamesList;

    @FindBy(css = "tr>td:nth-child(4)>img")
    private List<WebElement> descriptionImages;

    @FindBy(css = "tr>td:nth-child(4)>div>span")
    private List<WebElement> descriptionText;

    @FindBy(css = "tr>td:nth-child(4)>div>input")
    private List<WebElement> checkboxes;

    @FindBy(css = "tbody>tr:not(:first-child)")
    private List<WebElement> tableRowsList;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[1]")
    private WebElement userTableLogRecord;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return this.numberTypeDropdowns;
    }

    public List<WebElement> getUserNamesList() {
        return userNamesList;
    }

    public List<WebElement> getDescriptionImages() {
        return descriptionImages;
    }

    public List<WebElement> getDescriptionText() {
        return descriptionText;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<String> getUserNumberListText() {
        List<String> numbers = new ArrayList<>();
        userNumberList.forEach(t -> numbers.add(t.getText()));
        return numbers;
    }

    public List<String> getUserNamesText() {
        List<String> names = new ArrayList<>();
        userNamesList.forEach(t -> names.add(t.getText()));
        return names;
    }

    public List<String> getUserDescriptionText() {
        List<String> description = new ArrayList<>();
        descriptionText.forEach(t -> description.add(t.getText().trim().replace("\n", " ")));
        return description;
    }

    public void setCheckBoxByUserName(String userName) {
        for (WebElement tableRow : tableRowsList) {
            if (tableRow.findElement(By.tagName("a")).getText().equals(userName)) {
                tableRow.findElement(By.tagName("input")).click();
                break;
            }
        }
    }

    public String getUserTableLogRecordText() {
        return userTableLogRecord.getText();
    }

    public List<String> clickDropDownByUserName(String userName) {
        List<String> availableOptionsList = new ArrayList<>();
        for (WebElement tableRow : tableRowsList) {
            if (tableRow.findElement(By.tagName("a")).getText().equals(userName)) {
                tableRow.findElement(By.tagName("select")).click();
                tableRow.findElements(By.tagName("option")).forEach(option -> availableOptionsList.add(option.getText()));
                break;
            }
        }
        return availableOptionsList;
    }
}
