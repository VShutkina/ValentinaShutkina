package hw1.tests;

import hw1.common.AbstractBaseTest;
import hw1.common.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorAdditionTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "AdditionTestDataProvider")
    public void additionTest(int a, int b, int expected) {
        System.out.println("Addition test");
        long actual = calculator.sum(a,b);
        Assert.assertEquals(actual, expected);
    }
}
