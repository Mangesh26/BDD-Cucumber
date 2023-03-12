package StoryRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
		//jsonReport = "target/cucumber.json",
        //retryCount = 3,
        //detailedReport = true,
        //detailedAggregatedReport = false, 
        //overviewReport = true,
        //coverageReport = true,
        //jsonUsageReport = "target/cucumber-usage.json",
//        usageReport = true,
//        toPDF = true,
//        outputFolder = "target"
        )
@CucumberOptions(
				//format = {"Pretty","html:target/html"},
				//format={"SimpleHtmlReport:report/smokeTest.html"},
				strict = true,
				features = "src/main/resources/Feature/",
				glue = {"stepDefinition"},
//				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
//						"rerun:target/rerun.txt"
//						},
						plugin={"pretty:target/cucumber-htmlreport.text", "json:target/cucmber-report.json"},
				monochrome = true,
				tags = {"@Sanity"}
				//dryRun = true
				)

public class RunnerTest {

//	@AfterClass
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig("ExtentConfig/extent-config.xml");
//		Reporter.setSystemInfo("user", "Barca");
//        Reporter.setSystemInfo("os", "Windows 7");
//	}
	
}
