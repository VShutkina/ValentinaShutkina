package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class MetalsColorsPage extends AbstractBasePage {

    @FindBy(id = "submit-button")
    private SelenideElement submitButton;

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private ElementsCollection resultRecord;

    @FindBy(css = "p.radio>label")
    private ElementsCollection summaryRadioButtons;

    @FindBy(css = ".checkbox>label")
    private ElementsCollection checkboxElements;

    @FindBy(css = "button[title='Colors']")
    private SelenideElement colorButton;

    @FindBy(xpath = "//div[contains(@class, 'uui-form-element open')]//li//a")
    private ElementsCollection dropdownOptions;

    @FindBy(css = "#salad-dropdown>button")
    private SelenideElement vegetablesButton;

    @FindBy(css = "ul.dropdown-menu>li>a>label")
    private ElementsCollection vegetablesDropdownItems;

    @FindBy(css = "button[title='Metals']")
    private SelenideElement metalButton;

    public MetalsColorsPage() {
        page(this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickSummaryRadioButton(List<String> radioButton) {
        for (SelenideElement rb : summaryRadioButtons) {
            if (radioButton.contains(rb.getText())) {
                rb.click();
            }
        }
    }

    public void setCheckboxElement(List<String> checkbox) {
        for (SelenideElement cb : checkboxElements) {
            if (checkbox.contains(cb.getText())) {
                cb.click();
            }
        }
    }

    public SelenideElement getColorButton() {
        return colorButton;
    }

    public SelenideElement getMetalButton() {
        return metalButton;
    }

    public void clickColorDropdown(String colorOption) {
        for (SelenideElement colOpt : dropdownOptions) {
            if (colOpt.getText().equals(colorOption)) {
                colOpt.click();
                break;
            }
        }
    }

    public void clickVegetablesButton() {
        vegetablesButton.click();
    }

    public void setVegetablesDropdownItems(List<String> items) {
        for (SelenideElement di : vegetablesDropdownItems) {
            if (items.contains(di.getText())) {
                di.click();
            }
        }
    }

    public void unsetVegetablesItem() {
        for (SelenideElement di : vegetablesDropdownItems) {
            if (di.getText().contains("Vegetables")) {
                di.click();
                break;
            }
        }
    }

    public void selectMetalDropdown(String metalOption) {
        for (SelenideElement metal : dropdownOptions) {
            if (metal.getText().equals(metalOption)) {
                metal.click();
                break;
            }
        }
    }

    public ElementsCollection getResultRecord() {
        return resultRecord;
    }
}
