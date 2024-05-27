Feature: Swag Labs Login

  Scenario: Successful login with valid credentials
    Given the user is on the Swag Labs login page
    When the user enters the username "standard_user" and the password "secret_sauce"
    And clicks on the login button
    Then the user should be redirected to the home page

  Scenario: Unsuccessful login with invalid password
    Given the user is on the Swag Labs login page
    When the user enters the username "standard_user" and the password "secret_sauc"
    And clicks on the login button
    Then an error message should be displayed
