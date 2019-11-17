package hw1.tests;

import hw1.common.AbstractBaseTest;
import hw1.common.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivisionTest extends AbstractBaseTest {
    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "DivisionTestDataProvider")
    public void divisionTest(int a, int b, int expected) {
        System.out.println("Division test");
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }
}
