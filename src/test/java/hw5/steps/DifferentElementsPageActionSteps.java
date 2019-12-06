package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageActionSteps extends AbstractSteps {

    public DifferentElementsPageActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Set checkbox {0}")
    public void setCheckBox(final String checkBox) {
        differentElementsPage.setCheckBox(checkBox);
    }

    @Step("Select radio button {0}")
    public void selectRadioButton(final String radioButton) {
        differentElementsPage.selectRadioButton(radioButton);
    }

    @Step("Select color {0}")
    public void selectColor(final String color) {
        differentElementsPage.selectColor(color);
    }
}
