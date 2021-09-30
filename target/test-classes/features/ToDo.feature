@Automation
Feature:  To Do Item- Positive Flow
    Scenario Outline: Adding of To Do list of item
      Given user is on home page of the application
      When user enters todo item "<toDoItem>" in the search box
      And  when user clicks on enter
      Then user should see the todo item added on the page
      And the user is on Active tab
      And the user should see "<numberOfItems>" item left on Active tab
      When user clicks on All tab
      Then user should see the todo item added on the page
      And the user should see "<numberOfItems>" item left on All tab
      Examples:
        |toDoItem       |numberOfItems|
        | Logo Designing|1            |


  Scenario Outline: Completing of To Do list of item
    Given user is on home page of the application
    When user enters todo item "<toDoItem>" in the search box
    And  when user clicks on enter
    Then user should see the todo item added on the page
    And the user is on Active tab
    And the user should see "<numberOfItems>" item left on Active tab
    When user clicks on All tab
    And clicks on circle icon to complete the item
    And user clicks on completed tab
    Then Then user should see the todo item added on the completed page
    Then the user should see "<completedNumberOfItems>" item left on Complete tab
    Examples:
      |toDoItem       |numberOfItems|completedNumberOfItems|
      | Logo Designing|1            |0                     |

  Scenario Outline: Editing of To Do list of item
    Given user is on home page of the application
    When user enters todo item "<toDoItem>" in the search box
    And  when user clicks on enter
    Then user should see the todo item added on the page
    And the user is on Active tab
    And the user should see "<numberOfItems>" item left on Active tab
    When user clicks on All tab
    And user double click on the item added
    And user appends "<newValue>" to the item added in search box
    And  when user clicks on enter
    Then the updated value "<updatedValue>" should get displayed on All tab
    Examples:
      |toDoItem       |numberOfItems|newValue                   |updatedValue          |
      | Logo Designing|1            |Courses                    |Logo DesigningCourses |


  Scenario Outline: Deleting of To Do list of item
    Given user is on home page of the application
    When user enters todo item "<toDoItem>" in the search box
    And  when user clicks on enter
    Then user should see the todo item added on the page
    And the user is on Active tab
    And the user should see "<numberOfItems>" item left on Active tab
    When user clicks on All tab
    And user double click on the item added
    And user appends "<newValue>" to the item added in search box
    And  when user clicks on enter
    Then the updated value "<updatedValue>" should get displayed on All tab
    And user clicks on cross icon to delete the item added
    Then the user should see search box only
    Examples:
      |toDoItem       |numberOfItems|newValue                   |updatedValue          |deletedNumberOfItems|
      | Logo Designing|1            |Courses                    |Logo DesigningCourses |0                   |



  Scenario Outline: Adding of multiple To Do list of item
    Given user is on home page of the application
    When user enters todo items  in the search box
      | Logo Designing|
      | Solving Maths |
      | Architecture  |
      | Playing soccer|
      | Solving Maths |
      | Solving Puzzle|
      | Entertainment |
    Then the items should be displayed in the all tab
      | Logo Designing|
      | Solving Maths |
      | Architecture  |
      | Playing soccer|
      | Solving Maths |
      | Solving Puzzle|
      | Entertainment |
    Then user should see "<number>" items left in footer section on all tab
    And user clicks on active tab
    Then user should see "<number>" items left in footer section on Active tab
    And user clicks on completed tab
    Then user should see "<number>" items left in footer section on completed tab
    Examples:
      |number |
      |7      |



