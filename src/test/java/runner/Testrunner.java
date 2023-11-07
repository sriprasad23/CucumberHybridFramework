package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*_________________________________________________________________________________________________________________
 1. 
 2.
 3. 
 4.
 5.hooks = 
 6.plugin="pretty" is used to view with color in console and to get html report using html:and target folder .html extension we get html report under target folder 
 	we copy that html report and we can share through email
 7. piblish = true [cucmber report will be published in cloud that url we find in https we copy and share that generated but duration will only 24 hours]
 
_____________________________________________________________________________________________________________________ */

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource/features",
				 glue= {"stepdefinitions","hooks"}, publish = true,
				 plugin={"pretty","html:target/CucumberReports/CucumberReport.html"}
				
				 )

public class Testrunner {
	
	

}
