package bdd.pages;

import bdd.utility.DriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class ToDoPage
 {
     public static String itemToBeAddedText="";
     public static String editedNewToDoItemName="";
     public static List<String> actualToDosItemList;

    By searchBox = By.className("new-todo");

    By editBox= By.xpath("//label[@data-reactid='.0.1.2.$e9179629-03cc-4579-8efb-588b0d27fc15.0.1']");

     By noOfItemsOnFooter = By.xpath("//span[@class='todo-count']");

     By activeTab=By.xpath("//a[@href='#/active']");

     By completedTab=By.xpath("//a[@href='#/completed']");

     By allTab=By.xpath("//a[@href='#/']");
     By crossButton=By.xpath("//button[@class='destroy']");

    public void openUrl() {
        DriverConfig.setDriverConfiguration();
    }

    public void enterToDoItemInSearchBox(String toDoItem) {

       new DriverConfig().driver.findElement(searchBox).sendKeys(toDoItem);
       itemToBeAddedText=toDoItem;

    }

     public void clickOnEnter() {
        try {
            Thread.sleep(5000);
            new Actions(DriverConfig.driver).sendKeys(Keys.ENTER).build().perform();
        }catch (Exception e)
        {
            System.out.println("Not able to click");
        }
     }

     public void checkActiveTabStatus() {
         Assert.assertTrue("Expected:- Active tab should be enabled but the current status is:- "+DriverConfig.driver.findElement(activeTab).isEnabled(),DriverConfig.driver.findElement(activeTab).isEnabled());
     }

     public void checkForToDoItem() {

         Assert.assertEquals(itemToBeAddedText,DriverConfig.driver.findElement(By.xpath("//label[contains(text(),'"+itemToBeAddedText+"')]")).getText());
     }

     public void clickOnAllTab() {
        try {
            Thread.sleep(2000);
            DriverConfig.driver.findElement(allTab).click();
        }catch (Exception e)
        {
            System.out.println("Unable to click on All tab "+e.getMessage());
        }
     }

     public void checkNoOfItemsOnPage(String noOfItems) {
        Assert.assertEquals(noOfItems+" item left", DriverConfig.driver.findElement(noOfItemsOnFooter).getText());
     }

     public void tearDown()
     {
        DriverConfig.driver.quit();
     }

     public void clickOnCirclrcleIcon() {

         new Actions(DriverConfig.driver).click(DriverConfig.driver.findElement(By.className("toggle"))).build().perform();
     }

     public void clickOnCompletedTab() {
      DriverConfig.driver.findElement(completedTab).click();
     }

     public void checkNoOfItemsOnCompletedTab(String noOfItemsLeft) {
         Assert.assertEquals(noOfItemsLeft+" items left", DriverConfig.driver.findElement(noOfItemsOnFooter).getText());
     }

     public void dbClickOnToDos() {
         try {
         new Actions(DriverConfig.driver).doubleClick(DriverConfig.driver.findElement(By.xpath("//label[contains(text(),'"+itemToBeAddedText+"')]"))).build().perform();
             Thread.sleep(5000);

         }catch (Exception e)
         {
            System.out.println("Unable to double click:- "+e.getMessage());
         }

    }

     public void enterValueInEditSearchBox(String newvalue) {
         DriverConfig.driver.findElement(By.xpath("//input[@class='edit']")).sendKeys(newvalue);
         editedNewToDoItemName=newvalue;
     }

     public void checkUpdatedToDoItemName(String updatedToDoItemName) {
        Assert.assertEquals(updatedToDoItemName,DriverConfig.driver.findElement(By.xpath("//label[contains(text(),'"+itemToBeAddedText+"')]")).getText())  ;
    }

     public void clickOnCrossIconToDelete() {
        DriverConfig.driver.findElement(crossButton).click();

     }

     public void checkVisibilityOfSearchBox() {
        Assert.assertTrue("Expected:- Search box should get displayed but current status is :-"+DriverConfig.driver.findElement(searchBox).isDisplayed(),DriverConfig.driver.findElement(searchBox).isDisplayed());
     }

     public void addMultipleItems(List<String> listOfItems) {
        for(int i=0;i<listOfItems.size();i++)
        {
            DriverConfig.driver.findElement(searchBox).sendKeys((CharSequence) listOfItems.get(i));

            new Actions(DriverConfig.driver).sendKeys(Keys.ENTER).build().perform();
            DriverConfig.driver.findElement(searchBox).click();

        }
     }

     public void checkMultipleToDosItem(List<String> expectedItemList) {
        System.out.println(expectedItemList);
         actualToDosItemList=new ArrayList<>();
        List<WebElement> webElements= DriverConfig.driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        for(int i=0;i<webElements.size();i++)
        {
            actualToDosItemList.add(webElements.get(i).getText());
        }
        System.out.println("Actual To Do Items displayed on Screen are:- "+actualToDosItemList);
        for(int i=0;i<actualToDosItemList.size();i++)
        {
            Assert.assertTrue("Actual list of Items displayed on Page :-"+actualToDosItemList+" and Expected list of items are :-"+expectedItemList,actualToDosItemList.contains(expectedItemList.get(i)));
        }

     }

     public void checkMultipleNoOfItemsOnPage(String noOfItems)
     {
         Assert.assertEquals(noOfItems+" items left", DriverConfig.driver.findElement(noOfItemsOnFooter).getText());

     }

     public void clickOnActiveTab() {
        DriverConfig.driver.findElement(activeTab).click();
     }
 }