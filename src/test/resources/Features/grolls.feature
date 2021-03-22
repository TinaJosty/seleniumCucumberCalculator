Feature: grolls
  In order to avoid silly mistakes As a math idiot I want to be told the sum of two numbers

  Scenario: Add 2 black t-shirts to the basket
    Given I have opened grolls
    And I have chosen the <size> i want
    And I have chosen the <quantity>
    When I press Lägg i varukorg
    Then there should be <amountOfItems> in the basket
