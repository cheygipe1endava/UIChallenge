Feature: Login

  Scenario: The user unsuccessfully signs in Falabella's web page
    Given The user is in Falabella's home page
    And Opens login form overlay
    When The user types in invalid credentials
    And Clicks login button
    Then Page shows error with email or password to the user

  Scenario: The user successfully signs in Falabella's web page
    Given The user is in Falabella's home page
    And Opens login form overlay
    When The user types in valid credentials
    And Clicks login button
    Then User should be signed in

