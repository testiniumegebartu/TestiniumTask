package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonReader {
    private static final List<Map<String, String>> locators;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            locators = mapper.readValue(
                    new File("src/test/resources/locators.json"),
                    new TypeReference<List<Map<String, String>>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load locators.json file: " + e.getMessage());
        }
    }

    public static By getLocator(String key) {
        for (Map<String, String> locator : locators) {
            if (locator.get("key").equals(key)) {
                String type = locator.get("type");
                String value = locator.get("value");

                switch (type.toLowerCase()) {
                    case "id":
                        return By.id(value);
                    case "css":
                        return By.cssSelector(value);
                    case "xpath":
                        return By.xpath(value);
                    default:
                        throw new IllegalArgumentException("Invalid locator type: " + type);
                }
            }
        }
        throw new IllegalArgumentException("Locator not found for key: " + key);
    }
}
