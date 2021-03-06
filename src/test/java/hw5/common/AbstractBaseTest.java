package hw5.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners({AttachmentListener.class})
public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected Properties testProperties;

    @BeforeSuite
    public void suiteSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);
        WebDriverSingleton.INSTANCE.setDriver(driver);

        testProperties = new Properties();
        try {
            testProperties.load(new FileInputStream("src/main/resources/user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            driver.close();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
