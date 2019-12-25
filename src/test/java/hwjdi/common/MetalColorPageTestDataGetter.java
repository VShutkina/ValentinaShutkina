package hwjdi.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hwjdi.entities.MetalColorFormFiller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class MetalColorPageTestDataGetter {

    public static Object[] getMetalColorPageTestData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileReader fileReader = new FileReader(
                "src/test/resources/hwjdi/JDI_ex8_metalsColorsDataSet.json")) {
            Map<String, MetalColorFormFiller> testDataMap = objectMapper.
                    readValue(fileReader, new TypeReference<Map<String,
                            MetalColorFormFiller>>() {
                    });
            return testDataMap.values().toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
