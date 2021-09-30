package bdd.stepDef;

import bdd.pages.ToDoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ToDoImpl {

  ToDoPage toDoPage = new ToDoPage();


    @Given("user is on home page of the application")
    public void user_is_on_home_page_of_the_application() {
        toDoPage.openUrl();

    }
    @When("user enters todo item {string} in the search box")
    public void user_enters_todo_item_in_the_search_box(String toDoItem) {
       toDoPage.enterToDoItemInSearchBox(toDoItem);
    }
    @When("when user clicks on enter")
    public void when_user_clicks_on_enter() {
      toDoPage.clickOnEnter();

    }
    @Then("user should see the todo item added on the page")
    public void user_should_see_the_todo_item_added_on_the_page() {
    toDoPage.checkForToDoItem();
    }

  @And("the user is on Active tab")
  public void theUserIsOnActiveTab() {
      toDoPage.checkActiveTabStatus();
  }

  @And("the user should see {string} item left on Active tab")
  public void theUserShouldSeeItemLeftOnActiveTab(String noOfItems) {
      toDoPage.checkNoOfItemsOnPage(noOfItems);
  }

    @And("the user should see {string} item left on All tab")
    public void theUserShouldSeeItemLeftOnAllTab(String noOfItems) {
        toDoPage.checkNoOfItemsOnPage(noOfItems);
        toDoPage.tearDown();
    }

  @When("user clicks on All tab")
  public void userClicksOnAllTab() {
      toDoPage.clickOnAllTab();
  }

    @And("clicks on circle icon to complete the item")
    public void clicksOnCircleIconToCompleteTheItem() {
        toDoPage.clickOnCirclrcleIcon();
    }

    @And("user clicks on completed tab")
    public void userClicksOnCompletedTab() {
        toDoPage.clickOnCompletedTab();
    }

    @Then("the user should see {string} item left on Complete tab")
    public void theUserShouldSeeItemLeftOnCompleteTab(String noOfItemsLeft) {
        toDoPage.checkNoOfItemsOnCompletedTab(noOfItemsLeft);
    }

    @Then("Then user should see the todo item added on the completed page")
    public void thenUserShouldSeeTheTodoItemAddedOnTheCompletedPage() {
        toDoPage.checkForToDoItem();
    }

    @And("user double click on the item added")
    public void userDoubleClickOnTheItemAdded() {
        toDoPage.dbClickOnToDos();
    }

    @And("user appends {string} to the item added in search box")
    public void userAppendsToTheItemAddedInSearchBox(String newvalue) {
        toDoPage.enterValueInEditSearchBox(newvalue);
    }

    @Then("the updated value {string} should get displayed on All tab")
    public void theUpdatedValueShouldGetDisplayedOnAllTab(String updatedItemName) {
        toDoPage.checkUpdatedToDoItemName(updatedItemName);
    }

    @And("user clicks on cross icon to delete the item added")
    public void userClicksOnCrossIconToDeleteTheItemAdded() {
        toDoPage.clickOnCrossIconToDelete();
    }

    @Then("the user should see search box only")
    public void theUserShouldSeeSearchBoxOnly() {
        toDoPage.checkVisibilityOfSearchBox();
        toDoPage.tearDown();
    }

    @When("user enters todo items  in the search box")
    public void userEntersTodoItemsInTheSearchBox(DataTable table) {
        List<String> listOfItems = table.asList();
        toDoPage.addMultipleItems(listOfItems);
    }

    @Then("the items should be displayed in the all tab")
    public void theItemsShouldBeDisplayedInTheAllTab(DataTable table) {
        toDoPage.clickOnAllTab();
        toDoPage.checkMultipleToDosItem(table.asList()) ;

    }

    @And("user should see {string} items left in footer section on all tab")
    public void userShouldSeeItemsLeftInFooterSectionOnAllTab(String itemsOnAllTab) {
        toDoPage.checkMultipleNoOfItemsOnPage(itemsOnAllTab);

    }

    @And("user should see {string} items left in footer section on Active tab")
    public void userShouldSeeItemsLeftInFooterSectionOnActiveTab(String itemsOnActiveTab) {
        toDoPage.checkMultipleNoOfItemsOnPage(itemsOnActiveTab);
    }

    @And("user clicks on active tab")
    public void userClicksOnActiveTab() {
        toDoPage.clickOnActiveTab();

    }

    @Then("user should see {string} items left in footer section on completed tab")
    public void userShouldSeeItemsLeftInFooterSectionOnCompletedTab(String noOfItems) {
        toDoPage.checkNoOfItemsOnCompletedTab(noOfItems);
    }
}
