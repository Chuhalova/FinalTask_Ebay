Feature: Test
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario: Check the ability to register successfully
    Given User opens homepage
    And User opens registration page
    When User fills the registration form with the correct values
    And User clicks on button to finalize registration
    Then User goes to homepage and opens menu popup
    And User checks the registration success and profile information

  Scenario: Check the ability to login successfully
    Given User opens homepage
    And User opens login page
    When User fills forms and clicks on button to finalize login
    Then User goes to homepage and opens menu popup
    And User checks the registration success and profile information

  Scenario: Check the impossibility of creating an account with the data of an already registered user
    Given User opens homepage
    And User opens registration page
    When User fills the registration form with the incorrect values
    And User clicks on button to finalize registration
    Then User checks the registration fail

  Scenario: Check the ability to logout successfully
    Given User opens homepage
    And User opens login page
    And User fills forms and clicks on button to finalize login
    Then User goes to homepage and opens menu popup
    And User clicks logout button
    And User checks success of logging out

  Scenario Outline: Check the correctness of the search
    Given User opens homepage
    When User search '<product>'
    Then User gets page with products
    And User checks the correctness of the '<searchOutput>'

    Examples:
      | product                     | searchOutput                |
      | sparkling peeling lemon gel | sparkling,peeling,lemon,gel |
      | michael kors backpack       | michael,kors,backpack       |

  Scenario: Check the correctness of adding product to the list
    Given User opens homepage
    And User opens login page
    When User fills forms and clicks on button to finalize login
    And User opens products page from the homepage
    And User adds to watchlist product
    Then User checks the correctness of adding product to the list
    And User removes the product from the watchlist

  Scenario: Check the correctness of adding product to the cart
    Given User opens homepage
    And User opens login page
    When User fills forms and clicks on button to finalize login
    And User opens koreanProductsPage
    And User clicks on product from the bestsellers products
    And User adds to cart product
    Then User checks the correctness of adding product to the cart
    And User removes last product from the cart

  Scenario: User checks the ability to buy product
    Given User opens homepage
    And User opens login page
    When User fills forms and clicks on button to finalize login
    And User goes to the page with phones from the menu
    And User click opens phone page
    And User clicks on buy button
    Then User checks ordered product

  Scenario: User checks the correctness of cart num
    Given User opens homepage
    And User opens login page
    When User fills forms and clicks on button to finalize login
    And User clicks on the first daily deals product
    And User adds to cart product
    Then User checks the cart num
    And User removes last product from the cart







