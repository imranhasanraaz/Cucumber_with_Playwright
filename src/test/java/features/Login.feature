Feature: Login feature

  Scenario: User try to login with valid credentials
    Given User is on the login page
    When User input username "standard_user"
    And User input password "secret_sauce"
    And User click on the login button
    Then User successfully logged in
    And User should see the inventory page