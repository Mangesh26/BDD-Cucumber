Feature: User is able to test the login functiionality

  @Sanity
  Scenario Outline: Sucessful login with valid data
    Given User launch the aplication
    And User enter Username<userName> and Password<password>
    When User click on submit button
    Then Application should not navigate to home page
    Examples: 
      | userName      | password  |
      | abc@gmail.com | test		  |
