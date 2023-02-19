package testRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//JAICHANDRAN//IdeaProjects//cucumberBDD//Features//Orders.feature",
        glue = "stepdefs", monochrome = true, dryRun = false, plugin = {"pretty","html:target/HtmlReports"}
)
public class testRunner {
}
