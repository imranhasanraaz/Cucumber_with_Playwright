Feature: Login to the application

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters the username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the products page
    And the products page title should be "Products"
