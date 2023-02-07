package cucumberOptions;

import base.PageBase;
import base.TestBase;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features="src/test/java/features/Signin.feature",
        tags = "not @ignore",
        glue={"stepDefinition",
            "cucumber.hook"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenarios.txt"
        }
)

public class TestNgTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
