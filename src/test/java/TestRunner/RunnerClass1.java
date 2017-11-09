package TestRunner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.File;
import java.io.IOException;
import com.cucumber.listener.Reporter;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/Resources",glue = "Defs",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/extentreports/report.html"},
        tags= {"@Invalidlogin"})
public class RunnerClass1 {

   @AfterClass
   public static void setup() throws IOException {
      Reporter.loadXMLConfig(new File("src//test//java//Resources//extent-config.xml"));
      Reporter.setSystemInfo("user", System.getProperty("user.name"));

      Reporter.setTestRunnerOutput("Sample test runner output message <br />");
      Reporter.addStepLog("Step Log message goes here");
      Reporter.addScenarioLog("Add scenario log");

   }


   }
