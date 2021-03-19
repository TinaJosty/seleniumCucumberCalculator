Feature: addition
  In order to avoid silly mistakes As a math idiot I want to be told the sum of two numbers

  Scenario Outline: Add two numbers
    Given I have opend the web-application
    And I have entered <first> into the calculator
    And I have also entered <second> into the calculator
    When I press Find Addition
    Then the result should be <result> on the screen
    Examples:
      | first | second | result |
      | 50    | 50     | 100    |
      | -50   | 50     | 0      |
      | -50   | -50    | -100   |