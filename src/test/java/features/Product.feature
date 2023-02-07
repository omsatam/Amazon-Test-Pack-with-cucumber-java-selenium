Feature: Verify Product Page of Application

Scenario: Verify Product Images Displayed Correctly
  Given User is on Amazon Landing Page
  When User Search for Product
  And User Selects Product From Search Results
  Then Verify Product Images Displayed Correctly
  And User Close Browser

Scenario: Verify User able to Open Image
  Given User is on Amazon Landing Page
    When User Search for Product
  And User Selects Product From Search Results
  Then Open Product Image and Verify it Opened
  And User Close Browser

Scenario: Verify User able to Select Images
  Given User is on Amazon Landing Page
    When User Search for Product
  And User Selects Product From Search Results
  Then Select Product Images and Verify Results
  And User Close Browser

  Scenario: Verify Product Opened is Correct
  Given User is on Amazon Landing Page
    When User Search for Product
  And User Selects Product From Search Results
  Then Verify Correct Product Opened
    And User Close Browser

  Scenario: Verify All Items in Product Page
  Given User is on Amazon Landing Page
    When User Search for Product
  And User Selects Product From Search Results
  Then Verify All Product Page Items
    And User Close Browser
    
Scenario: Verify Add to cart Increases Cart Quantity
  Given User is on Amazon Landing Page
    When User Search for Product
  And User Selects Product From Search Results
  Then Check Cart Quantity
  When User Add Product To Cart
  Then Check Cart Quantity and Verify Cart Quantity Increased
  And User Close Browser

Scenario: Verify Product Present in Wishlist after Adding
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  And User Sign In With valid Credentials
  When User Search for Product
  And User Selects Product From Search Results
  When User Adds product to wishlist
  Then Verify Wishlist page appears
  Then Add item to wishlist
  And Go to Wishlist
  Then Verify Product Available in Wishlist
  And Delete Created Wishlist
  And User Close Browser