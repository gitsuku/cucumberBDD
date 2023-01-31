Feature: login to the application

  Scenario Outline: test the login functionality
    Given I launch chrome browser
    When open application url
    And enter<username>and<password>
    And click on submit
    Then I verify logo on page
    And close browser

    Examples:
      | username            |  | password |
      | admin@yourstore.com |  | admin    |