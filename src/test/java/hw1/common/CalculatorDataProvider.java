package hw1.common;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider(name = "AdditionTestDataProvider")
    public Object[][] additionTestDataProvider() {
        return new Object[][] {
                {2, 2, 4},
                {5, 5, 10},
                {5, 10, 15}
        };
    }

    @DataProvider(name = "SubtractionTestDataProvider")
    public Object[][] subtractionTestDataProvider() {
        return new Object[][] {
                {4, 2, 2},
                {22, 5, 17},
                {5, 10, -5}
        };
    }

    @DataProvider(name = "DivisionTestDataProvider")
    public Object[][] divisionTestDataProvider() {
        return new Object[][] {
                {4, 2, 2},
                {20, 5, 4},
                {1, 1, 1}
        };
    }

    @DataProvider(name = "MultiplicationTestDataProvider")
    public Object[][] multiplicationTestDataProvider() {
        return new Object[][] {
                {4, 2, 8},
                {20, 5, 100},
                {1, -1, -1}
        };
    }
}
