package Screens;

import org.openqa.selenium.WebDriver;
import Utils.JsonReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountManagementScreen extends BaseScreen{

    public AccountManagementScreen(WebDriver driver) {
        super(driver);
    }


    public void clearInput() {
        clearInput(JsonReader.getLocator("EditAccountNameInputValue"));
    }

    public void isElementVisibleWithLocatorKey(String locatorKey) {
        isElementVisible(locatorKey);
    }

    public String verifyInputValue(String locator) {
        try {
            return getText(locator).trim();
        } catch (Exception e) {
            throw new RuntimeException("Değer doğrulama sırasında hata oluştu.", e);
        }
    }

    public boolean isInputValueEmpty(String locator) {
        try {
            WebElement inputField = waitForElement(JsonReader.getLocator(locator));
            String value = inputField.getAttribute("value");
            return value == null || value.trim().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Input alanı kontrol edilirken hata oluştu: " + locator, e);
        }
    }
}