Feature: Verifying the login functiionality

  @Sanity
  Scenario Outline: Verify login with valid data
    Given User launch the aplication
    And User enter Username<userName> and Password<password>
    When User click on submit button
    Then Application should navigate to home page
    Examples: 
      | userName      | password  	|
      | standard_user | secret_sauce|

  @Sanity
  Scenario Outline: Verify user not able to login with invalid data
    Given User launch the aplication
    And User enter Username<userName> and Password<password>
    When User click on submit button
    Then Application should not navigate to home page
    Examples: 
      | userName      | password  	|
      | standard_user | secret_sauce1|