package hw1.tests;

import hw1.common.AbstractBaseTest;
import hw1.common.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtractionTest extends AbstractBaseTest {
    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "SubtractionTestDataProvider")
    public void subtractionTest(int a, int b, int expected) {
        System.out.println("Subtraction test");
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }
}
