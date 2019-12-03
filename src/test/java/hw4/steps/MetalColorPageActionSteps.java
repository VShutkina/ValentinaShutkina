package hw4.steps;

import hw4.MetalsColorsPage;
import hw4.testdata.MetalColorPageTestData;

public class MetalColorPageActionSteps extends AbstractSteps {

    public void fillFormOnMetalsColorsPage(MetalsColorsPage metalsColorsPage,
                                           MetalColorPageTestData testData) {
        if (testData.getSummaryList() != null) {
            metalsColorsPage.clickSummaryRadioButton(testData.getSummaryList());
        }

        if (testData.getElementsList() != null) {
            metalsColorsPage.setCheckboxElement(testData.getElementsList());
        }

        if (testData.getColor() != null) {
            metalsColorsPage.getColorButton().click();
            metalsColorsPage.clickColorDropdown(testData.getColor());
        }

        if (testData.getMetal() != null) {
            metalsColorsPage.getMetalButton().pressEnter();
            metalsColorsPage.selectMetalDropdown(testData.getMetal());
        }

        if (testData.getVegetablesList() != null) {
            metalsColorsPage.clickVegetablesButton();
            if (testData.getVegetablesList().size() > 0) {
                metalsColorsPage.unsetVegetablesItem();
                metalsColorsPage.setVegetablesDropdownItems(testData.getVegetablesList());
            }
        }
    }
}
