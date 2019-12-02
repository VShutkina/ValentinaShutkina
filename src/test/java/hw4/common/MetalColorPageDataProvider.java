package hw4.common;

import hw4.testdata.MetalColorPageTestData;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.ColorsItems.*;
import static hw4.enums.ElementsItems.*;
import static hw4.enums.MetalsItems.*;
import static hw4.enums.SummaryItems.*;
import static hw4.enums.VegetablesItems.*;

public class MetalColorPageDataProvider {

    @DataProvider(name = "TestDataMetalColor")
    public Object[][] testDataMetalColor() {
        return new Object[][]{
                {MetalColorPageTestData.metalColorBuilder().
                        setElementsList(Arrays.asList(EARTH.getValue())).
                        setColor(YELLOW.getValue()).
                        setMetal(GOLD.getValue()).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setSummaryList(Arrays.asList(THREE.getValue(), EIGHT.getValue())).
                        setVegetablesList(Arrays.asList(CUCUMBER.getValue(), TOMATO.getValue())).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setSummaryList(Arrays.asList(THREE.getValue(), TWO.getValue())).
                        setElementsList(Arrays.asList(WATER.getValue(), WIND.getValue(), FIRE.getValue())).
                        setMetal(BRONZE.getValue()).
                        setVegetablesList(Arrays.asList(ONION.getValue())).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setSummaryList(Arrays.asList(SIX.getValue(), FIVE.getValue())).
                        setElementsList(Arrays.asList(WATER.getValue())).
                        setColor(GREEN.getValue()).
                        setMetal(SELEN.getValue()).
                        setVegetablesList(Arrays.asList(
                                CUCUMBER.getValue(),
                                TOMATO.getValue(),
                                VEGETABLES.getValue(),
                                ONION.getValue())).
                        build()},
                {MetalColorPageTestData.metalColorBuilder().
                        setElementsList(Arrays.asList(FIRE.getValue())).
                        setColor(BLUE.getValue()).
                        setVegetablesList(Arrays.asList(CUCUMBER.getValue(), TOMATO.getValue(), VEGETABLES.getValue())).
                        build()},
        };
    }
}
