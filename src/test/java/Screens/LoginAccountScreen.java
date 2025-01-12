package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.JsonReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAccountScreen extends BaseScreen{

    public LoginAccountScreen(WebDriver driver) {
        super(driver);
    }


    public void enterUsername(String username) {
        clearSendKeys(JsonReader.getLocator("LoginUsername"), username);
    }

    public void enterPassword(String password) {
        clearSendKeys(JsonReader.getLocator("LoginPassword"), password);
    }

    public void clickLoginButton() {
        click(JsonReader.getLocator("LoginButton"));
    }

    public void clickLogoutButton() {
        click(JsonReader.getLocator("LogoutButton"));
    }
    public boolean isUsernameVisible() {
        return isElementVisible("LoginUsername");
    }
    public boolean isPasswordVisible() {
        return isElementVisible("LoginPassword");
    }
    public boolean isLoginButtonVisible() {
        return isElementVisible("LoginButton");
    }
    public boolean isLogoutButtonVisible() {
        return isElementVisible("LogoutButton");
    }

    public boolean isOpenMoneyTransferButtonVisible() {
        return isElementVisible("OpenMoneyTransferButton");
    }

    public boolean isMyAccountAmountValuePresent() {
        return isTextPresent(JsonReader.getLocator("MyAccountAmountValue"));
    }
    public boolean isOverlayRoutingCorrect(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[text()='"+text+"']/following-sibling::div[@class='css-146c3p1 r-lrvibr r-1loqt21']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}