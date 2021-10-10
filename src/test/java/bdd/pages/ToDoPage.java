package bdd.pages;

import bdd.utility.DriverConfig;
import bdd.utility.LogHelper;
import bdd.utility.SeleniumActionHelper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ToDoPage
{
    public static String itemToBeAddedText="";
    public static String editedNewToDoItemName="";
    public static List<String> actualToDosItemList;

    By searchBox = By.className("new-todo");

    By editBox= By.xpath("//input[@class='edit']");

    By noOfItemsOnFooter = By.xpath("//span[@class='todo-count']");

    By activeTab=By.xpath("//a[@href='#/active']");

    By completedTab=By.xpath("//a[@href='#/completed']");

    By allTab=By.xpath("//a[@href='#/']");

    By crossButton=By.xpath("//button[@class='destroy']");

    By completeButton = By.xpath("//input[@class='toggle']");

    By allToDoList = By.xpath("//ul[@class='todo-list']/li");

    public void openUrl()    {

        DriverConfig.setDriverConfiguration();
    }

    public void enterToDoItemInSearchBox(String toDoItem)    {

       SeleniumActionHelper.typeValue(DriverConfig.driver.findElement(searchBox),toDoItem);
        itemToBeAddedText=toDoItem;
    }

    public void clickEnter()    {

        SeleniumActionHelper.clickOnEnter();

    }

    public void checkActiveTabStatus()    {

        Assert.assertTrue("Expected:- Active tab should be enabled but the current status is:- "+SeleniumActionHelper.getIsEnabledStatus(DriverConfig.driver.findElement(activeTab)),SeleniumActionHelper.getIsEnabledStatus(DriverConfig.driver.findElement(activeTab)));
    }

    public void checkForToDoItem() {

        Assert.assertEquals(itemToBeAddedText,SeleniumActionHelper.getTextValue(DriverConfig.driver.findElement(By.xpath("//label[contains(text(),'"+itemToBeAddedText+"')]"))));
    }

    public void clickOnAllTab()    {

        SeleniumActionHelper.clickOnElement(DriverConfig.driver.findElement(allTab));
    }

    public void checkNoOfItemsOnPage(String noOfItems)    {

        Assert.assertEquals(noOfItems+" item left", SeleniumActionHelper.getTextValue(DriverConfig.driver.findElement(noOfItemsOnFooter)));
    }


    public void clickOnCirclrcleIcon()    {

        SeleniumActionHelper.clickByAction(DriverConfig.driver,DriverConfig.driver.findElement(completeButton));
        //new Actions(DriverConfig.driver).click(DriverConfig.driver.findElement(completeButton)).build().perform();
    }

    public void clickOnCompletedTab()    {

        SeleniumActionHelper.clickOnElement(DriverConfig.driver.findElement(completedTab));
    }

    public void checkNoOfItemsOnCompletedTab(String noOfItemsLeft)    {

        Assert.assertEquals(noOfItemsLeft+" items left", SeleniumActionHelper.getTextValue(DriverConfig.driver.findElement(noOfItemsOnFooter)));
    }

    public void dbClickOnToDos()    {

        SeleniumActionHelper.dblClickOnElement(DriverConfig.driver.findElement(By.xpath("//label[contains(text(),'"+itemToBeAddedText+"')]")));
    }

    public void enterValueInEditSearchBox(String newvalue)    {

        SeleniumActionHelper.typeValue(DriverConfig.driver.findElement(editBox),newvalue);
        editedNewToDoItemName=newvalue;
    }

    public void checkUpdatedToDoItemName(String updatedToDoItemName)    {

        Assert.assertEquals(updatedToDoItemName,SeleniumActionHelper.getTextValue(DriverConfig.driver.findElement(By.xpath("//label[contains(text(),'"+itemToBeAddedText+"')]"))));
    }

    public void clickOnCrossIconToDelete()    {

        SeleniumActionHelper.clickOnElement(DriverConfig.driver.findElement(crossButton));
    }

    public void checkVisibilityOfSearchBox()    {

        Assert.assertTrue("Expected:- Search box should get displayed but current status is :-"+SeleniumActionHelper.getIsDisplayedStatus(DriverConfig.driver.findElement(searchBox)),SeleniumActionHelper.getIsDisplayedStatus(DriverConfig.driver.findElement(searchBox)));
    }

    public void addMultipleItems(List<String> listOfItems)    {

        for(int i=0;i<listOfItems.size();i++)    {

            SeleniumActionHelper.typeValue(DriverConfig.driver.findElement(searchBox),listOfItems.get(i));
            SeleniumActionHelper.clickOnEnter();
            SeleniumActionHelper.clickOnElement(DriverConfig.driver.findElement(searchBox));
        }
    }

    public void checkMultipleToDosItem(List<String> expectedItemList)     {

        LogHelper.info("Expected To Do's List: "+expectedItemList);
        actualToDosItemList=new ArrayList<>();
        List<WebElement> webElements= SeleniumActionHelper.findAllElements(DriverConfig.driver,allToDoList);

        for(int i=0;i<webElements.size();i++)    {

            actualToDosItemList.add(SeleniumActionHelper.getTextValue(webElements.get(i)));
        }
        LogHelper.info("Actual To Do Items displayed on Screen are:- "+actualToDosItemList);

        for(int i=0;i<actualToDosItemList.size();i++)    {

                if(expectedItemList.size()!=actualToDosItemList.size())    {

                        Assert.fail("Expected List Size is: "+expectedItemList.size()+" and actualToDos list size displayed on UI is: "+actualToDosItemList.size());
                }
                else
                        Assert.assertTrue("Actual list of Items displayed on Page :-"+actualToDosItemList+" and Expected list of items are :-"+expectedItemList,actualToDosItemList.contains(expectedItemList.get(i)));
        }

    }

    public void checkMultipleNoOfItemsOnPage(String noOfItems)    {

        Assert.assertEquals(noOfItems+" items left", SeleniumActionHelper.getTextValue(DriverConfig.driver.findElement(noOfItemsOnFooter)));
    }

    public void clickOnActiveTab()    {

        SeleniumActionHelper.clickOnElement(DriverConfig.driver.findElement(activeTab));
    }
}