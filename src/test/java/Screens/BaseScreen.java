package Screens;

import Utils.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected WebDriver driver;
    private final WebDriverWait wait;
    protected final Logger logger;
    public BaseScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.logger = LogManager.getLogger(this.getClass());
    }


    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void click(By locator) {
        waitForElement(locator).click();
    }


    public void clearSendKeys(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void clearInput(By locator) {
        WebElement element = waitForElement(locator);
        element.clear();
    }
    public void Bekleme(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }


    public boolean isElementVisible(String locatorKey) {
        try {
            waitForElement(JsonReader.getLocator(locatorKey));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getText(String locatorKey) {
        try {
            WebElement element = waitForElement(JsonReader.getLocator(locatorKey));
            return element.getText().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAttribute(By locator, String attribute) {
        try {
            WebElement element = waitForElement(locator);
            String value = element.getAttribute(attribute);
            return (value != null) ? value.trim() : null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Attribute '" + attribute + "' alınamadı: " + locator, e);
        }
    }
    public void clickElement(String locatorKey) {
        WebElement element = waitForElement(JsonReader.getLocator(locatorKey));
        element.click();
    }

    public boolean isTextDisplayed(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@dir='auto' and contains(., '"+text+"')] | //span[contains(., '"+text+"')]")));
            return true;
        } catch (Exception e) {
                return false;
        }
    }

    public void clickWithText(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@dir='auto' and contains(., '"+text+"')] | //span[contains(., '"+text+"')]")));
            button.click();
        } catch (Exception e) {
                throw new RuntimeException(text + " butonuna tıklanamadı.");

        }
    }

    public boolean isTextPresent(By locator) {
        try {
            String text = waitForElement(locator).getText().trim();
            return !text.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }


}
