package Steps;

import Screens.AccountManagementScreen;
import Screens.LoginAccountScreen;
import Tests.BaseTest;
import Utils.JsonReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class AccountManagementStep {

    private static final Logger logger = LogManager.getLogger(LoginAccountScreen.class);
    private final AccountManagementScreen accountManagementScreen;

    public AccountManagementStep() {
        this.accountManagementScreen = new AccountManagementScreen(BaseTest.getDriver());
    }


    @And("Edit account alanındaki account name {string} olduğu kontrol edilir")
    public void checkAccountNameValue(String text) {
        String EditAccountAccountName = accountManagementScreen.getAttribute(JsonReader.getLocator("EditAccountNameInputValue"),"value");
        System.out.println(EditAccountAccountName);
        Assert.assertEquals(text,EditAccountAccountName,"'"+text+"' değeri beklenen '"+EditAccountAccountName+"' değeri ile eşit değil.");
        logger.info("Beklenen account name doğru olduğu görüldü. - PASS");
    }
    @And("{string} elementin disabled olduğu kontrol edilir")
    public void checkElementDisabled(String localKey) {
        String isDisable = accountManagementScreen.getAttribute(JsonReader.getLocator(localKey),"aria-disabled");
        Assert.assertNotNull(isDisable, "Element disabled değil.");
        logger.info("Elementin disabled olduğu görüldü. - PASS");
    }

    @And("{string} elementi kontrol edilir")
    public void checkElementVisible(String locatorKey) {
        accountManagementScreen.isElementVisible(locatorKey);
        logger.info("'"+locatorKey+"' elementi göründü. - PASS");
    }

    @And("Edit account alanindaki account name inputu silinir")
    public void clearAccountName() {
        accountManagementScreen.clearInput();
        logger.info("Input alanı başarıyla silindi. - PASS");
    }

    @And("{string} elementine {string} değeri girilir")
    public void sendKeysElement(String locatorKey, String text) {
        accountManagementScreen.clearSendKeys(JsonReader.getLocator(locatorKey),text);
        logger.info("Input alanı başarıyla silindi. - PASS");
    }

    @And("{int} saniye bekle")
    public void waitFor10secs(int time) {
        accountManagementScreen.Bekleme(time);
        logger.info("Input alanı başarıyla silindi. - PASS");
    }

    @Then("{string} alanının değerinin {string} olduğu kontrol edilir")
    public void verifyFieldValue(String locatorKey, String expectedValue) {
        String actualValue = accountManagementScreen.verifyInputValue(locatorKey);
        Assert.assertEquals(actualValue,expectedValue,"Beklenen değer ile asıl değer aynı değil.");
        logger.info("Beklenen değer doğru. - PASS");
    }

    @Then("{string} alanının değerinin boş olduğu kontrol edilir")
    public void isInputValueEmpty(String locatorKey) {
        boolean isEmpty = accountManagementScreen.isInputValueEmpty(locatorKey);
        Assert.assertTrue(isEmpty,"Input alanı boş değil.");
        logger.info("Input alanı istenildiği gibi boş değil. - PASS");
    }


}
