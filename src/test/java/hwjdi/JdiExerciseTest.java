package hwjdi;

import hwjdi.common.AbstractBaseTest;
import hwjdi.common.MetalColorPageDataProvider;
import hwjdi.entities.JdiUser;
import hwjdi.entities.MetalColorFormFiller;
import org.testng.annotations.Test;

import static hwjdi.enums.HeaderListItems.METALS_AND_COLORS;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class JdiExerciseTest extends AbstractBaseTest {

    @Test(dataProviderClass = MetalColorPageDataProvider.class,
            dataProvider = "TestDataMetalColor")
    public void jdiMetalsAndColorsFormTest(MetalColorFormFiller metalColorFormFiller) {
        JdiSite.open();
        JdiSite.login(JdiUser.USER);
        String actualUserName = JdiSite.homePage.getUserName();
        assertEquals(actualUserName, JdiUser.USER.getExpectedUserName(),
                format("Expected logged user: %s, but get %s",
                        JdiUser.USER.getExpectedUserName(), actualUserName));
        JdiSite.openPageInHeaderMenu(METALS_AND_COLORS.getName());
        JdiSite.metalsColorsPage.fillForm(metalColorFormFiller);
        String actualResultRecord = JdiSite.metalsColorsPage.getResultRecords();
        String expectedResultRecord = metalColorFormFiller.toString().
                replaceAll("\\[|\\]", "");
        assertEquals(expectedResultRecord, actualResultRecord,
                format("Expected actual result record is %s, but get %s",
                        expectedResultRecord, actualResultRecord));
        JdiSite.headerMenu.logout();
    }
}
