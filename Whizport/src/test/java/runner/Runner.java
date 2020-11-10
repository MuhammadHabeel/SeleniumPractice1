
package runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import utility.BasePage;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		jsonReport = "target/cucumber.json"
		,retryCount= 0
		,toPDF=true
		,outputFolder="target"
		)
@CucumberOptions(
		
				  features = {"src/test/java/features"
							
				  			}
				  
				, glue = {"stepDefinitions" }
				, monochrome = true
				, dryRun = true
				, strict = false 
				, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Test-Report/TestResult.html","pretty", "json:target/Test-Report/TestResult.json" }
				, tags = 
					{	
//							"@tag2"
			    "@Smoke6"
			 //+"," +",@Smoke" +",@Functional" +"@Regression"
					}
				)

public class Runner extends BasePage {	

	
}


