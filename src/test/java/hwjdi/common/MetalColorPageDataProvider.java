package hwjdi.common;

import org.testng.annotations.DataProvider;

public class MetalColorPageDataProvider {

    @DataProvider(name = "TestDataMetalColor")
    public Object[] testDataMetalColor() {
        return MetalColorPageTestDataGetter.getMetalColorPageTestData();
    }
}
