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
        String actualResultRecords = JdiSite.metalsColorsPage.getResultRecords();
        assertEquals(metalColorFormFiller.toString(), actualResultRecords,
                format("Expected actual result record is %s, but get %s",
                        metalColorFormFiller, actualResultRecords));
        JdiSite.headerMenu.logout();
    }
}
