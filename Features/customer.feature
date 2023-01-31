Feature: add customer

  Scenario Outline: adding a new customer
  Given I launch chrome browser
    When open application url
    And enter<username>and<password>
    And click on submit
    Then I verify logo on page
    Then user can view dashboard
    When user clicks on customer menu
    And clicks on customer menu item
    And clicks on add new button
    Then user can view add new customer page
    When user enter customer info
    And clicks on save button
    Then user can see confirmation message
    And close browser

    Examples:
      | username            |  | password |
      | admin@yourstore.com |  | admin    |