package bdd.stepDef;
import bdd.utility.DriverConfig;
import bdd.utility.LogHelper;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.Messages;

public class Hooks    {

    public Scenario scenario;

    @Before
    public void runScenario(Scenario scenario)
    {
        this.scenario=scenario;
        LogHelper.info("Starting execution of scenario: "+scenario.getName());

    }

    @After
    public void tearDown()
    {
        DriverConfig.driver.quit();
        LogHelper.info("Ended execution of scenario: "+scenario.getName());

    }
}
