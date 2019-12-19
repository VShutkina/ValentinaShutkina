package hwjdi;

import hwjdi.common.AbstractBaseTest;
import hwjdi.common.MetalColorPageDataProvider;
import hwjdi.entities.JdiUser;
import org.testng.annotations.Test;

public class JdiExerciseTest extends AbstractBaseTest {

    @Test(dataProviderClass = MetalColorPageDataProvider.class,
            dataProvider = "TestDataMetalColor")
    public void jdiMetalsAndColorsFormTest() {
        JdiUser jdiUser = new JdiUser(testProperties.getProperty("username"),
                testProperties.getProperty("password"),
                testProperties.getProperty("expectedUserName"));
        JdiSite.open();
        JdiSite.login(jdiUser);

    }
}
