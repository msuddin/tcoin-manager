Feature: To capture different types of data

  Scenario Outline: Report on commission wallet
    Given I navigate to site with user <username>
    When I enter username
    And I enter password
    And I press sign in
    And I wait for google authenticator to be completed
    Then I capture current commission amount
    And I capture current trade amount
    And I log out

    Examples:
      |username|
      |template|