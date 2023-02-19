Feature: Search customer
  Background: common steps
    Given I launch chrome browser
    When open application url
    And new enter username as "admin@yourstore.com" and password as "admin"
    And click on submit
    Then I verify logo on page
    Then user can view dashboard



  Scenario: search customer with email

    When user clicks on customer menu
    And clicks on customer menu item
   And enter email "WDCIbm@gmail.com"
    When clicks on search button
    Then user should found email
    And close browser

  Scenario: search customer with name

    When user clicks on customer menu
    And clicks on customer menu item
    And enter customer name "Victoria Terces"
    When clicks on search button
    Then user should find name "Victoria Terces"
    And close browser

