package hw2.ex2;

import hw2.common.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        WebElement serviceSupportSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Support')]"));
        softAssert.assertTrue(serviceSupportSubCategory.isDisplayed());
        WebElement serviceDatesSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Dates')]"));
        WebElement serviceComplTableSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Complex Table')]"));
        WebElement serviceSimplTableSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Simple Table')]"));
        WebElement serviceTableWithPagesSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Table with pages')]"));
        WebElement serviceDiffElemSubCategory =
                driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(.,'Different elements')]"));
        softAssert.assertTrue(serviceDatesSubCategory.isDisplayed());
        softAssert.assertTrue(serviceComplTableSubCategory.isDisplayed());
        softAssert.assertTrue(serviceSimplTableSubCategory.isDisplayed());
        softAssert.assertTrue(serviceTableWithPagesSubCategory.isDisplayed());
        softAssert.assertTrue(serviceDiffElemSubCategory.isDisplayed());
        softAssert.assertAll();

        // 6. Click on Service subcategory in the left section
        // and check that drop down contains options
        WebElement serviceHeaderLeftPanel = driver.findElement(By.
                xpath("//li[@class='menu-title']//a[contains(.,'Service')]"));
        serviceHeaderLeftPanel.click();
        WebElement serviceSupportSubCategoryLeftPanel = driver.findElement(
                By.xpath("//ul[@class='sub']//li[contains(.,'Support')]"));
        WebElement serviceDatesSubCategoryLeftPanel = driver.findElement(
                By.xpath("//ul[@class='sub']//li[contains(.,'Dates')]"));
        WebElement serviceComplTableSubCategoryLeftPanel = driver.findElement(
                By.xpath("//ul[@class='sub']//li[contains(.,'Complex Table')]"));
        WebElement serviceSimplTableSubCategoryLeftPanel = driver.findElement(
                By.xpath("//ul[@class='sub']//li[contains(.,'Simple Table')]"));
        WebElement serviceTableWithPagesSubCategoryLeftPanel = driver.findElement(
                By.xpath("//ul[@class='sub']//li[contains(.,'Table with pages')]"));
        WebElement serviceDiffElemSubCategoryLeftPanel = driver.findElement(
                By.xpath("//ul[@class='sub']//li[contains(.,'Different elements')]"));
        softAssert.assertTrue(serviceSupportSubCategoryLeftPanel.isDisplayed());
        softAssert.assertTrue(serviceDatesSubCategoryLeftPanel.isDisplayed());
        softAssert.assertTrue(serviceComplTableSubCategoryLeftPanel.isDisplayed());
        softAssert.assertTrue(serviceSimplTableSubCategoryLeftPanel.isDisplayed());
        softAssert.assertTrue(serviceTableWithPagesSubCategoryLeftPanel.isDisplayed());
        softAssert.assertTrue(serviceDiffElemSubCategoryLeftPanel.isDisplayed());
        softAssert.assertAll();

        // 7. Open through the header menu Service -> Different Elements Page
        serviceHeaderSubMenu.click();
        serviceDiffElemSubCategory.click();

        // 8. Check interface on Different elements page,
        // it contains all needed elements
        WebElement defaultButton = driver.findElement(By.name("Default Button"));
        softAssert.assertTrue(defaultButton.isDisplayed());
        WebElement Button = driver.findElement(By.cssSelector(".uui-button[type=button]"));
        softAssert.assertTrue(Button.isDisplayed());
        WebElement dropdown = driver.findElement(By.cssSelector(".colors"));
        softAssert.assertTrue(dropdown.isDisplayed());
        WebElement checkboxWater = driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(.,'Water')]"));
        softAssert.assertTrue(checkboxWater.isDisplayed());
        WebElement checkboxEarth = driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(.,'Earth')]"));
        softAssert.assertTrue(checkboxEarth.isDisplayed());
        WebElement checkboxWind = driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(.,'Wind')]"));
        softAssert.assertTrue(checkboxWind.isDisplayed());
        WebElement checkboxFire = driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(.,'Fire')]"));
        softAssert.assertTrue(checkboxFire.isDisplayed());
        WebElement radioGold = driver.findElement(By.xpath("//label[@class='label-radio' and contains(.,'Gold')]"));
        softAssert.assertTrue(radioGold.isDisplayed());
        WebElement radioSilver = driver.findElement(By.xpath("//label[@class='label-radio' and contains(.,'Silver')]"));
        softAssert.assertTrue(radioSilver.isDisplayed());
        WebElement radioBronze = driver.findElement(By.xpath("//label[@class='label-radio' and contains(.,'Bronze')]"));
        softAssert.assertTrue(radioBronze.isDisplayed());
        WebElement radioSelen = driver.findElement(By.xpath("//label[@class='label-radio' and contains(.,'Selen')]"));
        softAssert.assertTrue(radioSelen.isDisplayed());
        softAssert.assertAll();

        // 9. Assert that there is Right Section
        assertTrue(driver.findElement(By.id("mCSB_2")).isDisplayed());

        // 10. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        // 11. Select checkboxes
        // 12. Assert that for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox.
        checkboxWater.click();
        WebElement trueLogCheckboxWater = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Water')]"));
        assertTrue(trueLogCheckboxWater.getText().contains("Water: condition changed to true"));
        checkboxWind.click();
        WebElement trueLogCheckboxWind = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Wind')]"));
        assertTrue(trueLogCheckboxWind.getText().contains("Wind: condition changed to true"));

        // 13. Select radio
        // 14. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        radioSelen.click();
        WebElement trueLogradioSelen = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'metal')]"));
        assertTrue(trueLogradioSelen.getText().contains("value changed to Selen"));

        // 15. Select in dropdown
        // 16. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        Select colorsSelector = new Select(driver.findElement(By
                .xpath("//div[@class='colors']//select[@class='uui-form-element']")));
        colorsSelector.selectByVisibleText("Yellow");
        WebElement trueLogColorsSelector = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Colors')]"));
        assertTrue(trueLogColorsSelector.getText().contains("Colors: value changed to Yellow"));

        // 17. Unselect and assert checkboxes
        // 18. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        checkboxWater.click();
        WebElement falseLogCheckboxWater = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Water')]"));
        assertTrue(falseLogCheckboxWater.getText().contains("Water: condition changed to false"));
        checkboxWind.click();
        WebElement falseLogCheckboxWind = driver.findElement(By.
                xpath("//ul[@class='panel-body-list logs']//li[contains(.,'Wind')]"));
        assertTrue(falseLogCheckboxWind.getText().contains("Wind: condition changed to false"));


    }
}
