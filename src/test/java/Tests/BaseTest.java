package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

public class BaseTest {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    String url = "https://catchylabs-webclient.testinium.com/";

    public void setup(String browser) {
        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                    throw new IllegalArgumentException("Safari sadece macOS üzerinde desteklenir.");
                }
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Desteklenmeyen tarayıcı: " + browser);
        }
        logger.info("Setting up browser: " + browser);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver başlatılamadı");
        }
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
            logger.info("Tearing down the browser.");
        }
        //openAllureReport(); // allure raporunu terminale kodunu yazmadan açar
    }
    private void openAllureReport() {
        new Thread(() -> {
            try {
                Process process = Runtime.getRuntime().exec("cmd /c allure serve allure-results");
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
