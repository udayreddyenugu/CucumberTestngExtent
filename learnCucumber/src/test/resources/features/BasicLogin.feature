Feature: Login
  
  In order to perform sucessful login
  As a user
  I want to enter correct username and password

  Background: 
    Given user navigates to facebook website
    When user validates the homepage title

  Scenario Outline: In order to verify login to facebook as "<username>" user
    Then user enters "<username>" username
    And user enters "<password>" password
    And user age selection
      | Age      | country |
      | above 18 | India   |
      | below 18 | USA     |
    Then user "<loginType>" successfully logged in

    Examples: 
      | username | password | loginType |
      | valid    | valid    | should    |
      | invalid  | invalid  | shouldnot |
