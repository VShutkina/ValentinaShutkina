package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstExerciseTest extends AbstractBaseTest {

    @Test
    public void firstExerciseTest() {
        HomePage homePage = new HomePage(driver);

        // 1. Open test site by URL
        homePage.open();

        // 2. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        // 3. Perform login
        homePage.login("epam", "1234");

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.getUsernameLabelText(), "PITER CHAILOVSKII");

        // 5. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        // 6. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<String> expectedHeaderListItems = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> headerListItems = driver.findElements(By.xpath("//ul[contains(@class,'m-l8')]/li"));
        List<String> actualHeaderListItems = new ArrayList<>();
        headerListItems.forEach(t -> actualHeaderListItems.add(t.getText()));
        assertEquals(actualHeaderListItems, expectedHeaderListItems);

        // 7. Assert that there are 4 images on the Index Page and they are displayed
        WebElement iconPractice = driver.findElement(By.cssSelector(".icon-practise"));
        assertTrue(iconPractice.isDisplayed());
        WebElement iconCustom = driver.findElement(By.cssSelector(".icon-custom"));
        assertTrue(iconCustom.isDisplayed());
        WebElement iconMulti = driver.findElement(By.cssSelector(".icon-multi"));
        assertTrue(iconMulti.isDisplayed());
        WebElement iconBase = driver.findElement(By.cssSelector(".icon-base"));
        assertTrue(iconBase.isDisplayed());

        // 8. Assert that there are 4 texts on the Index Page
        // under icons and they have proper text
        List<String> expectedTextIconItems = Arrays.
                asList("To include good practices and ideas from successful EPAM project",
                        "To be flexible and customizable",
                        "To be multiplatform",
                        "Already have good base (about 20 internal and some external projects), wish to get more…");
        List<WebElement> textIconItems = driver.findElements(By.className("benefit-txt"));
        List<String> actualTextIconItems = new ArrayList<>();
        textIconItems.forEach(t -> actualTextIconItems.add(t.getText().replaceAll("\n", " ")));
        assertEquals(actualTextIconItems, expectedTextIconItems);

        // 9. Assert a text of the main headers
        String actualMainTitle = driver.findElement(By.cssSelector(".main-title")).getText();
        assertEquals(actualMainTitle, "EPAM FRAMEWORK WISHES…");
        String actualMainText = driver.findElement(By.cssSelector(".main-txt")).getText();
        assertTrue(actualMainText.contains("LOREM IPSUM"));

        // 10. Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.id("iframe"));
        assertTrue(iFrame.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo
        // in the left top conner of iframe
        driver.switchTo().frame(driver.findElement(By.id("iframe")));
        WebElement epamLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(epamLogo.isDisplayed());

        //12. Switch to original window back
        driver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        WebElement actualSubHeader = driver.findElement(By.linkText("JDI GITHUB"));
        assertEquals(actualSubHeader.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(actualSubHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        WebElement leftPanel = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftPanel.isDisplayed());

        //16. Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector(".footer-content"));
        assertTrue(footer.isDisplayed());

    }
}
