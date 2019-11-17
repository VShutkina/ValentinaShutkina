package hw1.tests;

import hw1.common.AbstractBaseTest;
import hw1.common.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultiplicationTest extends AbstractBaseTest {
    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "MultiplicationTestDataProvider")
    public void multiplicationTest(int a, int b, int expected) {
        System.out.println("Multiplication test");
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }
}
