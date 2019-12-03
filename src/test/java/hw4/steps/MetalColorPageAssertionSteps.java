package hw4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import hw4.MetalsColorsPage;
import hw4.testdata.MetalColorPageTestData;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;

public class MetalColorPageAssertionSteps extends AbstractSteps {

    public void checkResultOutputs(
            MetalsColorsPage metalsColorsPage,
            MetalColorPageTestData testData
    ) {
        for (SelenideElement resultElement : metalsColorsPage.getResultRecord()
        ) {
            if (resultElement.getText().contains("Summary") && testData.getSummaryList() != null) {
                resultElement.shouldHave(text(
                        getSummarySum(testData.getSummaryList())
                ));
            }
            if (resultElement.getText().contains("Color") && testData.getColor() != null) {
                resultElement.shouldHave(text(testData.getColor()));
            }
            if (resultElement.getText().contains("Metal") && testData.getMetal() != null) {
                resultElement.shouldHave(text(testData.getMetal()));
            }
            if (resultElement.getText().contains("Elements") && testData.getElementsList() != null) {
                resultElement.shouldHave(Condition.text(
                        String.join(", ", testData.getElementsList())
                ));
            }
            if (resultElement.getText().contains("Vegetables") && testData.getVegetablesList() != null) {
                resultElement.shouldHave(Condition.text(
                        String.join(", ", testData.getVegetablesList())
                ));
            }

        }

    }

    private String getSummarySum(List<String> sumList) {
        List<Integer> optionsIntList = new ArrayList<>();
        sumList.forEach(l -> optionsIntList.add(Integer.valueOf(l)));
        return String.valueOf(optionsIntList.stream().mapToInt(Integer::intValue).sum());
    }
}
