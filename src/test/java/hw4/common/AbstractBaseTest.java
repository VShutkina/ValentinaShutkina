package hw4.common;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractBaseTest {

    protected Properties testProperties;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.timeout = 4000;

        testProperties = new Properties();
        try {
            testProperties.load(new FileInputStream("src/main/resources/user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
