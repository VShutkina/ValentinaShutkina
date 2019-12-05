package hw5.steps;

import hw3.enums.HeaderListItems;
import hw3.enums.HeaderServiceItems;
import hw3.enums.IconItemsText;
import hw3.enums.LeftSideServiceItems;
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

    public void usernameOnTheHomePageShouldBe(final String username) {
        assertEquals(homePage.getUsernameLabelText(), username);
    }

    public void pageTitleOnTheHomePageShouldBe(final String pageTitle) {
        assertEquals(homePage.getPageTitle(), pageTitle);
    }

    public void checkThatHeaderListItemsShouldBe() {
        List<String> expectedHeaderListItems = Stream.of(HeaderListItems.values())
                .map(HeaderListItems::getName)
                .collect(Collectors.toList());
        assertEquals(homePage.getHeaderMenu().getHeaderMenuItemsText(), expectedHeaderListItems);
    }

    public void checkThatImagesOnTheHomePageAreDisplayed() {
        assertTrue(homePage.getIconPractice().isDisplayed());
        assertTrue(homePage.getIconCustom().isDisplayed());
        assertTrue(homePage.getIconMulti().isDisplayed());
        assertTrue(homePage.getIconBase().isDisplayed());
    }

    public void checkThatTextsIconsOnTheHomePageShouldBe() {
        List<String> expectedTextIconItems = Stream.of(IconItemsText.values())
                .map(IconItemsText::getText)
                .collect(Collectors.toList());
        assertEquals(homePage.getTextIconItems(), expectedTextIconItems);
    }

    public void checkThatMainTitleTextOnTheHomePageShouldBe(final String mainTitleText) {
        assertEquals(homePage.getMainTitleText(), mainTitleText);
    }

    public void checkThatMainTextOnTheHomePageShouldBe(final String mainText) {
        assertTrue(homePage.getMainText().contains(mainText));
    }

    public void checkThatIframeOnTheHomePageShouldBe() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    public void checkThatEpamLogoIsDisplayed() {
        assertTrue(homePage.getEpamLogo().isDisplayed());
    }

    public void checkThatTextInTheSubHeaderShouldBe(final String subHeaderLinkText) {
        assertEquals(homePage.getSubHeaderLinkText(), subHeaderLinkText);
    }

    public void checkThatLinkUrlSubHeaderShouldBe(final String subHeaderLinkUrl) {
        assertEquals(homePage.getSubHeaderLinkUrl(), subHeaderLinkUrl);
    }

    public void checkThatLeftPanelIsDisplayed() {
        assertTrue(homePage.getLeftSide().getWebElementLeftSide().isDisplayed());
    }

    public void checkThatFooterIsDisplayed() {
        assertTrue(homePage.getFooter().getWebElementFooter().isDisplayed());
    }

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
