package bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumActionHelper {


    static WebDriverWait webDriverWait = new WebDriverWait(DriverConfig.driver,20);

    public static void openUrl(WebDriver driver, String url)    {

        driver.manage().timeouts().pageLoadTimeout(70000,TimeUnit.MILLISECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public  static void clickOnElement(WebElement element)    {

        try    {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            LogHelper.info("Element is Clicked");
        }catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
    }

    public  static void clickByAction(WebDriver driver,WebElement element)    {

        try    {
            new Actions(driver).click(element).build().perform();
            LogHelper.info("Element is Clicked");
        }catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
    }

    public  static void dblClickOnElement(WebElement element)    {

        try    {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            new Actions(DriverConfig.driver).doubleClick(element).build().perform();
        }catch (Exception e)    {
            System.out.println(e.getMessage());
        }
    }

    public  static void typeValue(WebElement element,String value)    {

        DriverConfig.driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
        try    {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
            LogHelper.info("Value entered is: "+value);
        }catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
    }

    public  static void clickOnEnter()    {

        try    {
            new Actions(DriverConfig.driver).sendKeys(Keys.ENTER).build().perform();
            LogHelper.info("Enter is clicked");
        }catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
    }

    public static String getTextValue(WebElement element)    {
        DriverConfig.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        String text="";
        try    {
            text = element.getText();
            LogHelper.info("Text displayed on UI: "+text);
        }catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
        return text;
    }

    public static boolean getIsEnabledStatus(WebElement element)    {
        boolean flag=false;
        try    {
            flag = element.isEnabled();
            LogHelper.info("Enabled Status of element is: "+flag);
        } catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
        return flag;
    }

    public static boolean getIsDisplayedStatus(WebElement element)    {
        boolean flag=false;
        try    {
            flag = element.isDisplayed();
            LogHelper.info("Enabled Status of element is: "+flag);
        } catch (Exception e)    {
            LogHelper.error(e.getMessage());
        }
        return flag;
    }

    public static List<WebElement> findAllElements(WebDriver driver, By element)    {

        return driver.findElements(element);
    }

    public static void tearDown()    {

        DriverConfig.driver.quit();
    }
}
