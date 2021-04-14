Feature: This is to verify the Order information

  Background: Open Home page
    Given I am on home page "http://automationpractice.com/"

  Scenario: Verify Order Information
    And I Click on T-shirt Category
    And I mouse over to first product
    When I Click on add to cart button
    And I click on proceed to checkout button
    And I click on proceed to checkout in cart page
    And I enter email address to create an account
    And I enter personal Information, address Information
    And click on Register
    And click on proceed checkout after entering address information
    And I click on agree terms
    And I click on proceed checkout after agreeing terms
    And I click on pay by bankwire
    And I click on confirm order
    And get the OrderNumber from confirmation page
    And verify the orderNumber in the order history

  Scenario: Update Personal Information
    And I Click on SignIn
    And I enter email address to create an account
    And I enter personal Information, address Information
    And click on Register
    And click on Account
    And click on personal Information
    And update firstName
    When I click on Save
    Then Success message should be displayed


