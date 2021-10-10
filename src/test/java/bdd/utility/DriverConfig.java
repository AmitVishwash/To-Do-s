package bdd.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfig    {

    public static WebDriver driver;

    public static void setDriverConfiguration()    {

        new PropertyReader();

        if (PropertyReader.getPropertyValue("driver").equalsIgnoreCase("chrome"))    {

            System.setProperty("webdriver.chrome.driver", PropertyReader.getPropertyValue("driverPath") + "chromedriver.exe");
            driver = new ChromeDriver();
            SeleniumActionHelper.openUrl(driver, PropertyReader.getPropertyValue("url"));
        } else if (PropertyReader.getPropertyValue("driver").equalsIgnoreCase("firefox"))    {
            System.setProperty("webdriver.gecko.driver", PropertyReader.getPropertyValue("driverPath") + "geckodriver.exe");
            driver = new FirefoxDriver();
            SeleniumActionHelper.openUrl(driver, PropertyReader.getPropertyValue("url"));
        }

    }



}
