package hw3.steps;

import org.openqa.selenium.WebDriver;

public class DifferentElementsPageActionSteps extends AbstractSteps {

    public DifferentElementsPageActionSteps(WebDriver driver) {
        super(driver);
    }

    public void setCheckBox(final String checkBox) {
        differentElementsPage.setCheckBox(checkBox);
    }

    public void selectRadioButton(final String radioButton) {
        differentElementsPage.selectRadioButton(radioButton);
    }

    public void selectColor(final String color) {
        differentElementsPage.selectColor(color);
    }
}
