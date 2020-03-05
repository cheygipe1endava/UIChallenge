Feature: Registration

  Scenario: The user unsuccessfully register in Falabella's web page
    Given The user is in Falabella's home page

    And Goes to the registration page
    When The user fills all fields excepting 'celular'
    And Tries to save its data
    Then Web page displays error message to the user

