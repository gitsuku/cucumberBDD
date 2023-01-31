package testRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//Dell//IdeaProjects//cucumberBDD//Features//customer.feature",
        glue = "stepdefs", monochrome = true, plugin = {"pretty","html:target/HtmlReports"}
)
public class testRunner {
}
