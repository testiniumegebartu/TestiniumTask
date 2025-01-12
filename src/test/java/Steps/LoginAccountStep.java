package Steps;

import Screens.LoginAccountScreen;
import Tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class LoginAccountStep {
    private final LoginAccountScreen loginAccountScreen;
    private static final Logger logger = LogManager.getLogger(LoginAccountScreen.class);

    public LoginAccountStep() {
        this.loginAccountScreen = new LoginAccountScreen(BaseTest.getDriver());
    }


    @When("Kullanıcı kullanıcı adını {string} ve şifreyi {string} olarak login olunur")
    public void  userLogin(String username, String password) {
        loginAccountScreen.enterUsername(username);
        loginAccountScreen.enterPassword(password);
        loginAccountScreen.clickLoginButton();
        logger.info("Başarılı bir şekilde giriş yapıldı - PASS");
    }

    @Then("Login butonuna tıklanır")
    public void pressLoginButton() {
        loginAccountScreen.clickLoginButton();
        logger.info("Başarılı bir şekilde login butonuna tıklandı. - PASS");
    }

    @Then("Logout butonuna tıklanır")
    public void userLogout() {
        loginAccountScreen.clickLogoutButton();
        logger.info("Başarılı bir şekilde çıkış yapıldı - PASS");
    }

    @And("Kullanıcının Login sayfasında olup olmadığı kontrol edilir")
    public void checkUserInLoginPage() {
        Assert.assertTrue(loginAccountScreen.isUsernameVisible(),"Username alanı görünmüyor.");
        Assert.assertTrue(loginAccountScreen.isPasswordVisible(),"Password alanı görünmüyor.");
        Assert.assertTrue(loginAccountScreen.isLoginButtonVisible(),"login butonu görünmüyor.");
        logger.info("Login ekranı göründü. - PASS");
    }
    @And("Login butonunun görünür olup olmadığı kontrol edilir")
    public void checkLoginButtonVisible() {
        Assert.assertTrue(loginAccountScreen.isLoginButtonVisible(),"Login ekranı görünmüyor.");
        logger.info("Login butonu göründü. - PASS");
    }

    @And("Logout butonunun görünür olup olmadığı kontrol edilir")
    public void checkLogoutButtonVisible() {
        Assert.assertTrue(loginAccountScreen.isLogoutButtonVisible(),"Logout butonu görünmüyor.");
        logger.info("Logout butonu görünmekte. - PASS");
    }
    @And("Open Money Transfer butonunun görünür olup olmadığı kontrol edilir")
    public void checkOpenMoneyTransferButtonVisible() {
        Assert.assertTrue(loginAccountScreen.isOpenMoneyTransferButtonVisible(),"Open Money Transfer butonu görünmüyor.");
        logger.info("Open Money Transfer butonu göründü.. - PASS");
    }

    @And("Kullanıcının hesabına giriş yapıp yapmadığı kontrol edilir")
    public void checkUserInDashboardPage() {
        Assert.assertTrue(loginAccountScreen.isOpenMoneyTransferButtonVisible(),"Open Money Transfer butonu görünmüyor.");
        Assert.assertTrue(loginAccountScreen.isLogoutButtonVisible(),"Logout butonu görünmüyor.");
        logger.info("Hesaba giriş yapıldı. - PASS");
    }

    @Then("{string} texti kontrol edilir")
    @Then("{string} butonu kontrol edilir")
    public void verifyTextOnPage(String text) {
        Assert.assertTrue(loginAccountScreen.isTextDisplayed(text), text+" texti ekranda görünmüyor.");
        logger.info("'"+text+"' texti ekranda görünmekte. - PASS");
    }
    @Then("{string} textine tıklanır")
    @Then("{string} butonuna tıklanır")
    public void clickOnText(String text) {
        loginAccountScreen.clickWithText(text);
        logger.info("'"+text+"' textine tıklandı. - PASS");
    }

    @And("Bakiyede değer gözüktüğü kontrol edilir")
    public void checkAmountValueIsPresent() {
        Assert.assertTrue(loginAccountScreen.isMyAccountAmountValuePresent(),"Bakiyede değer görünmüyor.");
        logger.info("Bakiyede değer olduğu göründü. - PASS");
    }

    @And("{string} overlayinin açılıp açılmadığı kontrol edilir")
    public void checkOverlayRoutingCorrect(String text) {
        Assert.assertTrue(loginAccountScreen.isOverlayRoutingCorrect(text),"Overlay yönlendirmesi yanlış.");
        logger.info("'"+text+"' overlaye yönlendirildi. - PASS");
    }
    @And("{string} elementine tıklanır")
    public void clickElementwithLocatorKey(String locatorKey) {
        loginAccountScreen.clickElement(locatorKey);
        logger.info("'"+locatorKey+"' elementine tıklandı. - PASS");
    }

}
