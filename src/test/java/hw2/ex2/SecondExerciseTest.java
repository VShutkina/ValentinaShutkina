package hw2.ex2;

import hw2.common.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondExerciseTest extends AbstractBaseTest {

    @Test
    public void secondExerciseTest() {

        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI/");

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Assert User name in the left-top side of screen that user is loggined
        String actualLoggedUser = driver.findElement(By.id("user-name")).getText();
        assertEquals(actualLoggedUser, "PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        WebElement serviceHeaderSubMenu = driver.findElement(By.
                xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li[@class='dropdown']"));
        serviceHeaderSubMenu.click();
        List<String> expectedServiceSubItems = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");
        List<WebElement> actualServiceSubItems = new ArrayList<>();

        expectedServiceSubItems.forEach(
                t -> actualServiceSubItems.add(
                        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'" + t + "')]"))));
        actualServiceSubItems.forEach(t -> softAssert.assertTrue(t.isDisplayed()));
        softAssert.assertAll();

        // 6. Click on Service subcategory in the left section
        // and check that drop down contains options
        WebElement serviceHeaderLeftPanel = driver.findElement(By.
                xpath("//li[@class='menu-title']//a[contains(.,'Service')]"));
        serviceHeaderLeftPanel.click();
        List<WebElement> actualServiceSubItemsLeftPanel = new ArrayList<>();
        expectedServiceSubItems.forEach(t -> actualServiceSubItemsLeftPanel.add(
                driver.findElement(By.xpath("//ul[@class='sub']//li[contains(.,'" + t + "')]"))
        ));

        actualServiceSubItemsLeftPanel.forEach(t -> softAssert.assertTrue(t.isDisplayed()));
        softAssert.assertAll();

        // 7. Open through the header menu Service -> Different Elements Page
        serviceHeaderSubMenu.click();
        WebElement serviceDiffElemSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Different elements')]"));
        serviceDiffElemSubCategory.click();

        // 8. Check interface on Different elements page,
        // it contains all needed elements
        WebElement defaultButton = driver.findElement(By.name("Default Button"));
        softAssert.assertTrue(defaultButton.isDisplayed());
        WebElement Button = driver.findElement(By.cssSelector(".uui-button[type=button]"));
        softAssert.assertTrue(Button.isDisplayed());
        WebElement dropdown = driver.findElement(By.cssSelector(".colors"));
        softAssert.assertTrue(dropdown.isDisplayed());
        List<WebElement> checkBoxElements = driver.findElements(By.xpath("//label[@class='label-checkbox']"));
        //do soft assertion
        checkBoxElements.forEach(t -> softAssert.assertTrue(t.isDisplayed()));
        List<WebElement> radioBtnsElements = driver.findElements(By.xpath("//label[@class='label-radio']"));
        //do soft assertion
        radioBtnsElements.forEach(a -> softAssert.assertTrue(a.isDisplayed()));

        softAssert.assertAll();

        // 9. Assert that there is Right Section
        assertTrue(driver.findElement(By.id("mCSB_2")).isDisplayed());

        // 10. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        // 11. Select checkboxes
        // 12. Assert that for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox.
        WebElement checkboxWater = driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(.,'Water')]"));
        WebElement checkboxWind = driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(.,'Wind')]"));

        checkboxWater.click();
        WebElement trueLogCheckboxWater = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Water')]"));
        softAssert.assertTrue(trueLogCheckboxWater.getText().contains("Water: condition changed to true"));
        checkboxWind.click();
        WebElement trueLogCheckboxWind = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Wind')]"));
        softAssert.assertTrue(trueLogCheckboxWind.getText().contains("Wind: condition changed to true"));

        // 13. Select radio
        // 14. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        WebElement radioSelen = driver.findElement(By.xpath("//label[@class='label-radio' and contains(.,'Selen')]"));
        radioSelen.click();
        WebElement trueLogradioSelen = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'metal')]"));
        softAssert.assertTrue(trueLogradioSelen.getText().contains("value changed to Selen"));

        // 15. Select in dropdown
        // 16. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        Select colorsSelector = new Select(driver.findElement(By
                .xpath("//div[@class='colors']//select[@class='uui-form-element']")));
        colorsSelector.selectByVisibleText("Yellow");
        WebElement trueLogColorsSelector = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Colors')]"));
        softAssert.assertTrue(trueLogColorsSelector.getText().contains("Colors: value changed to Yellow"));

        // 17. Unselect and assert checkboxes
        // 18. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        checkboxWater.click();
        WebElement falseLogCheckboxWater = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Water')]"));
        softAssert.assertTrue(falseLogCheckboxWater.getText().contains("Water: condition changed to false"));
        checkboxWind.click();
        WebElement falseLogCheckboxWind = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Wind')]"));
        softAssert.assertTrue(falseLogCheckboxWind.getText().contains("Wind: condition changed to false"));
        softAssert.assertAll();

    }
}
