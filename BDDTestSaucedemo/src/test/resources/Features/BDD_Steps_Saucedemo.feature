  Feature: Saucedemo Login
  As a user
  I want to login to the Saucedemo website
  So I can add items to cart, checkout and logout

  Scenario: Login with valid credentials
    Given User is on the SauceDemo login page
    When User enters valid username and password
    And User clicks login button
    Then User is redirected to the SauceDemo inventory page
    
  Scenario: Login with invalid credentials
    Given User is on the SauceDemo login page
    When User enters invalid username and password
    And User clicks login button
    Then Error message is displayed
  
  Scenario: Add an item to cart,checkout,logout 
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
    Then I am redirected to the home page
    And User open item
    When I add an item to the cart
    Then the item is added to the cart
    And User proceeds to checkout
    And User fills out the checkout form with valid data
    And User confirms the purchase
    Then User should see the confirmation page
    And User redirected to the home page
    When User clicks the menu button
    When User clicks the Logout button
    Then User should be logged out successfully