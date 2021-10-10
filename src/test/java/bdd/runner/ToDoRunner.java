package bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ToDo.feature",
        tags = "@Automation",
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html","json:target/cucumber.json"},
         glue = "bdd.stepDef")

public class ToDoRunner    {

}
