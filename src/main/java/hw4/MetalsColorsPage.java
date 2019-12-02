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

    @FindBy(css = "div#colors>select")
    private SelenideElement colorDropdown;

    @FindBy(css = "#salad-dropdown>button")
    private SelenideElement vegetablesButton;

    @FindBy(css = "ul.dropdown-menu>li>a>input[type='checkbox']")
    private ElementsCollection vegetablesDropdownItems;

    @FindBy(css = "div#metals>select")
    private ElementsCollection metalDropdown;

    public MetalsColorsPage() {
        page(this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickSummaryRadioButton(String radioButton) {
        for (SelenideElement rb : summaryRadioButtons) {
            if (radioButton.equals(rb.getText())) {
                rb.click();
                break;
            }
        }
    }

    public void setCheckboxElement(String checkbox) {
        for (SelenideElement cb : checkboxElements) {
            if (checkbox.equals(cb.getText())) {
                cb.click();
                break;
            }
        }
    }

    public SelenideElement getColorDropdown() {
        return colorDropdown;
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

    public ElementsCollection getMetalDropdown() {
        return metalDropdown;
    }
}
