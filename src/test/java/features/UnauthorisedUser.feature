Feature: Verify Unauthorised User accessibility.

  Scenario: User must sign in to check out
    Given User is on Amazon Landing Page
    When User Search for Product
    And User Selects Product From Search Results
    When User Add Product To Cart
    And User Begins Checkout
    Then Verify Signin Page appears
    And User Close Browser

  Scenario: User must sign in to add items to wish list
    Given User is on Amazon Landing Page
    When User Search for Product
    And User Selects Product From Search Results
    When User Adds product to wishlist
    Then Verify Signin Page appears
    And User Close Browser

  Scenario: User must sign in to buy product
    Given User is on Amazon Landing Page
    When User Search for Product
    And User Selects Product From Search Results
    When User clicks on Buy product now
    Then Verify Signin Page appears
    And User Close Browser

  Scenario: Verify Username is not Displayed For Unauthorised User
    Given User is on Amazon Landing Page
    Then Verify Username is not Displayed
    And User Close Browser

  Scenario: Verify Returns & Orders is not Displayed For Unauthorised User
    Given User is on Amazon Landing Page
    Then Verify Returns & Orders is not Displayed
    And User Close Browser

  Scenario: Verify Your Account Section For Unauthorised User
    Given User is on Amazon Landing Page
    Then Verify Every Item of Your Account Section for Unauthorised User
    And User Close Browser