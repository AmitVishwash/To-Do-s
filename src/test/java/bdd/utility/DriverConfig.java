package bdd.utility;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverConfig {

    public static WebDriver driver;
    public static void setDriverConfiguration()
    {
        new PropertyReader();
        if(PropertyReader.getPropertyValue("driver").equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",PropertyReader.getPropertyValue("driverPath")+"chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(PropertyReader.getPropertyValue("url"));
            driver.manage().window().maximize();
        }
        else if (PropertyReader.getPropertyValue("driver").equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",PropertyReader.getPropertyValue("driverPath")+"geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(PropertyReader.getPropertyValue("url"));
            driver.manage().window().maximize();
        }

    }

}
