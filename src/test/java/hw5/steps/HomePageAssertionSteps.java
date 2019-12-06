package hw5.steps;

import hw3.enums.HeaderListItems;
import hw3.enums.HeaderServiceItems;
import hw3.enums.IconItemsText;
import hw3.enums.LeftSideServiceItems;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageAssertionSteps extends AbstractSteps {

    SoftAssert softAssert = new SoftAssert();

    public HomePageAssertionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Username should be {0} on the Home Page")
    public void usernameOnTheHomePageShouldBe(final String username) {
        assertEquals(homePage.getUsernameLabelText(), username);
    }

    @Step("Page title should be {0} on the Home Page")
    public void pageTitleOnTheHomePageShouldBe(final String pageTitle) {
        assertEquals(homePage.getPageTitle(), pageTitle);
    }

    @Step("Header List Items should be presented in Header Menu")
    public void checkThatHeaderListItemsShouldBe() {
        List<String> expectedHeaderListItems = Stream.of(HeaderListItems.values())
                .map(HeaderListItems::getName)
                .collect(Collectors.toList());
        assertEquals(homePage.getHeaderMenu().getHeaderMenuItemsText(), expectedHeaderListItems);
    }

    @Step("Icons should be displayed on Home Page")
    public void checkThatImagesOnTheHomePageAreDisplayed() {
        assertTrue(homePage.getIconPractice().isDisplayed());
        assertTrue(homePage.getIconCustom().isDisplayed());
        assertTrue(homePage.getIconMulti().isDisplayed());
        assertTrue(homePage.getIconBase().isDisplayed());
    }

    @Step("Text should be presented for Icons on Home Page")
    public void checkThatTextsIconsOnTheHomePageShouldBe() {
        List<String> expectedTextIconItems = Stream.of(IconItemsText.values())
                .map(IconItemsText::getText)
                .collect(Collectors.toList());
        assertEquals(homePage.getTextIconItems(), expectedTextIconItems);
    }

    @Step("Main title {0} should be displayed on Home Page")
    public void checkThatMainTitleTextOnTheHomePageShouldBe(final String mainTitleText) {
        assertEquals(homePage.getMainTitleText(), mainTitleText);
    }

    @Step("Main text {0} should be displayed on Home Page")
    public void checkThatMainTextOnTheHomePageShouldBe(final String mainText) {
        assertTrue(homePage.getMainText().contains(mainText));
    }

    @Step("Iframe should be displayed on Home Page")
    public void checkThatIframeOnTheHomePageShouldBe() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("EPAM logo should be displayed on Home Page")
    public void checkThatEpamLogoIsDisplayed() {
        assertTrue(homePage.getEpamLogo().isDisplayed());
    }

    @Step("{0} Sub Header link text should be displayed")
    public void checkThatTextInTheSubHeaderShouldBe(final String subHeaderLinkText) {
        assertEquals(homePage.getSubHeaderLinkText(), subHeaderLinkText);
    }

    @Step("Sub header link url should be {0}")
    public void checkThatLinkUrlSubHeaderShouldBe(final String subHeaderLinkUrl) {
        assertEquals(homePage.getSubHeaderLinkUrl(), subHeaderLinkUrl);
    }

    @Step("Left Panel should be presented")
    public void checkThatLeftPanelIsDisplayed() {
        assertTrue(homePage.getLeftSide().getWebElementLeftSide().isDisplayed());
    }

    @Step("Footer should be presented")
    public void checkThatFooterIsDisplayed() {
        assertTrue(homePage.getFooter().getWebElementFooter().isDisplayed());
    }

    @Step("all expected Service items should be displayed in Header Menu")
    public void checkHeaderMenuServiceItems() {
        List<String> headerMenuExpectedServiceSubItems = Stream.of(HeaderServiceItems.values())
                .map(HeaderServiceItems::getName)
                .collect(Collectors.toList());
        softAssert.assertEquals(homePage
                        .getHeaderMenu()
                        .getHeaderMenuServiceItemsText(),
                headerMenuExpectedServiceSubItems);
        softAssert.assertAll();
    }

    @Step("all expected Service items should be displayed in Left Side")
    public void checkLeftSideServiceItems() {
        List<String> leftPanelExpectedServiceSubItems = Stream.of(LeftSideServiceItems.values())
                .map(LeftSideServiceItems::getName)
                .collect(Collectors.toList());
        softAssert.assertEquals(homePage
                        .getLeftSide()
                        .getLeftPanelMenuServiceItemsText(),
                leftPanelExpectedServiceSubItems);
        softAssert.assertAll();
    }
}
