package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import hw4.HomePage;
import hw4.TableWithPagesPage;
import hw4.common.AbstractBaseTest;
import hw4.enums.HeaderServiceItems;
import hw4.enums.LeftSideServiceItems;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static hw4.enums.HeaderListItems.SERVICE;
import static hw4.enums.HeaderServiceItems.TABLE_WITH_PAGES;
import static hw4.enums.LeftSideListItems.SERVICE_LEFT_PANEL;
import static hw4.enums.ShowEntities.FIVE;
import static hw4.enums.ShowEntities.TEN;
import static org.testng.Assert.assertEquals;

public class FirstExerciseTest extends AbstractBaseTest {

    final private String searchText = "Custom";

    @Test
    public void firstExerciseTest() {

        // 1. Open test site by URL
        open("https://epam.github.io/JDI/");
        HomePage homePage = new HomePage();
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();

        // 2. Assert Browser title
        assertEquals(homePage.getTitle(), "Home Page");

        //3. Perform login
        homePage.login(testProperties.getProperty("username"), testProperties.getProperty("password"));

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.getUsernameLabelText().shouldHave(text(testProperties.getProperty("expectedUserName")));

        //5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        homePage.getHeaderMenu().headerMenuItemClick(SERVICE.getName());
        List<String> expectedHeaderServiceSubItems = Stream.of(HeaderServiceItems.values())
                .map(HeaderServiceItems::getName)
                .collect(Collectors.toList());
        homePage.getHeaderMenu().getServiceCollectiomSubItems().shouldHave(texts(expectedHeaderServiceSubItems));

        //6. Click on Service subcategory in the left
        // section and check that drop down contains options
        homePage.getLeftSide().leftPanelMenuItemsClick(SERVICE_LEFT_PANEL.getValue());
        List<String> leftPanelExpectedServiceSubItems = Stream.of(LeftSideServiceItems.values())
                .map(LeftSideServiceItems::getName)
                .collect(Collectors.toList());
        homePage.getLeftSide().getLeftPanelServiceCollectionSubItems().shouldHave(texts(leftPanelExpectedServiceSubItems));

        //7. Open through the header menu Service -> Table with pages
        homePage.getHeaderMenu().headerMenuItemClick(SERVICE.getName());
        homePage.getHeaderMenu().headerSubMenuItemClick(TABLE_WITH_PAGES.getName());

        //8. Check that default value for “Show entries” dropdown is 5
        tableWithPagesPage.getShowTableEntitiesDropdown().getSelectedOption()
                .shouldHave(text(FIVE.getValue()));

        //9. Assert that there is Right Section
        tableWithPagesPage.getRightSide().should(visible);

        //10. Assert that there is Left Section
        tableWithPagesPage.getLeftSide().getSelenideElementLeftSide().should(visible);

        //11. Select new value for the entries in the dropdown list
        tableWithPagesPage.getShowTableEntitiesDropdown().selectOptionByValue(TEN.getValue());

        //12. Assert that for the dropdown there is an individual log
        // row and value is corresponded to the value of dropdown.
        tableWithPagesPage.getLogRecord().shouldHave(text(TEN.getValue()));

        //13. Assert that in the table displayed corrected amount of entries
        tableWithPagesPage.getTableRows().shouldHave(CollectionCondition.size(TEN.getIntValue()));

        //14. Type in “Search” text field
        tableWithPagesPage.getSearchInput().sendKeys(searchText);

        //15. Assert the table contains only records with Search field value
        tableWithPagesPage.getSortedTableRows().forEach(e -> e.shouldHave(text(searchText)));

        //logout
        tableWithPagesPage.getHeaderMenu().logout();
    }


}
