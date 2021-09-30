package bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ToDo.feature",
        tags = "@Automation",
        publish = true,
        plugin = {"pretty", "html:build/reports/cucumber", "json:target/cucumber.json"},
         glue = "bdd.stepDef")
public class ToDoRunner {
}
