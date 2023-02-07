Feature: Verify Authorised User can accessibility.

Scenario: User must sign in to check out
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Sign In With valid Credentials
  When User Search for Product
  And User Selects Product From Search Results
  When User Add Product To Cart
  And User Begins Checkout
  Then Verify that Checkout page appears
  And User Close Browser

Scenario: User must sign in to add items to wish list
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Sign In With valid Credentials
  When User Search for Product
  And User Selects Product From Search Results
  When User Adds product to wishlist
  Then Verify Wishlist page appears
  And User Close Browser

Scenario: User must sign in to buy product
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Sign In With valid Credentials
  When User Search for Product
  And User Selects Product From Search Results
  When User clicks on Buy product now
  Then Verify that Checkout page appears
  And User Close Browser

Scenario: Verify Username is Displayed For Authorised User
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Sign In With valid Credentials
  Then Verify Username Displayed
  And User Close Browser

Scenario: Verify Returns & Orders Displayed For Authorised User
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Sign In With valid Credentials
  Then Verify Returns & Orders is Displayed
  And User Close Browser

Scenario: Verify Your Account Section For Authorised User
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Sign In With valid Credentials
  Then Verify Every Item of Your Account Section for Authorised User
  And User Close Browser