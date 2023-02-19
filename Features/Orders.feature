Feature: sales department
  Scenario: validate orders with complete status only
    Given I launch chrome browser
    When open application url
    And new enter username as "admin@yourstore.com" and password as "admin"
    And click on submit
    Then I verify logo on page
    When user clicks on salesmenu
    And clicks on orders button
    Then verify orders status
