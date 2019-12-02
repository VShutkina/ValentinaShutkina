package hw4.common;

import hw4.enums.*;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.SummaryItems.THREE;

public class MetalColorPageDataProvider {

    @DataProvider(name = "TestDataMetalColor")
    public Object[][] testDataMetalColor() {
        return new Object[][]{
                {MetalColorPageTestData.metalColorBuilder().
                        setElementsList(Arrays.asList(ElementsItems.EARTH.getValue())).
                        setColor(ColorsItems.YELLOW.getValue()).
                        setMetal(MetalsItems.GOLD.getValue()).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setSummaryList(Arrays.asList(THREE.getValue(), SummaryItems.EIGHT.getValue())).
                        setVegetablesList(Arrays.asList(VegetablesItems.CUCUMBER.getValue(), VegetablesItems.TOMATO.getValue())).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setSummaryList(Arrays.asList(THREE.getValue(), SummaryItems.TWO.getValue())).
                        setElementsList(Arrays.asList(ElementsItems.WATTER.getValue(), ElementsItems.WIND.getValue(), ElementsItems.FIRE.getValue())).
                        setMetal(MetalsItems.BRONZE.getValue()).
                        setVegetablesList(Arrays.asList(VegetablesItems.ONION.getValue())).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setSummaryList(Arrays.asList(SummaryItems.SIX.getValue(), SummaryItems.FIVE.getValue())).
                        setElementsList(Arrays.asList(ElementsItems.WATTER.getValue())).
                        setColor(ColorsItems.GREEN.getValue()).
                        setMetal(MetalsItems.SELEN.getValue()).
                        setVegetablesList(Arrays.asList(VegetablesItems.TOMATO.getValue(),
                                VegetablesItems.CUCUMBER.getValue(),
                                VegetablesItems.ONION.getValue(),
                                VegetablesItems.VEGETABLES.getValue())).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setElementsList(Arrays.asList(ElementsItems.FIRE.getValue())).
                        setColor(ColorsItems.BLUE.getValue()).
                        setVegetablesList(Arrays.asList(VegetablesItems.CUCUMBER.getValue(), VegetablesItems.TOMATO.getValue(), VegetablesItems.VEGETABLES.getValue())).
                        build()},
        };
    }
}
