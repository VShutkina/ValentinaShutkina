package hw1.common;

import com.epam.tat.module4.Calculator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseTest {

    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        this.calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
