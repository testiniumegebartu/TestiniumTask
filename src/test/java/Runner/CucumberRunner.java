package Runner;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import Tests.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@allScenarios",
        //tags = "@smoke",
        //tags = "@regression",

        //tags = "@loginAccount",
        //tags = "@login",
        //tags = "@account",

        //tags = "@accountManagement",
        //tags = "@transferMoney",
        //tags = "@addMoney",
        //tags = "@editAccount",



        plugin = {"pretty", "html:target/cucumber-reports.html"},
        //plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/Features",
        glue = {"Steps"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    private static final BaseTest baseTest = new BaseTest();

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        baseTest.setup(browser);
    }

    @AfterMethod
    public void tearDown() {
        baseTest.tearDown();
    }

}
