Feature: Verify Search Functionality of Application

  Scenario: Verify Default Search Dropdown Category in Searchbox
    Given User is on Amazon Landing Page
    And Default Search Dropdown Category is "All"
    And User Close Browser

  Scenario: Verify Search Dropdown Categories in Searchbox
    Given User is on Amazon Landing Page
    When User Changes Dropdown Category The same should be displayed
    And User Close Browser

  Scenario: Verify User able to see relevant items after Typing in Search Box
  Given User is on Amazon Landing Page
  When User Type in Searchbox
  Then Check Recommendations are Displaying correctly
    And User Close Browser

  Scenario: Verify User able to open required item after Clicking on Required Product
    Given User is on Amazon Landing Page
    When User Type in Searchbox
    Then Check Recommendations are Displaying correctly
    When User Search From Recommended Product
    Then Verify Search Results
    And User Close Browser

  Scenario: Verify User able to Search for Product
    Given User is on Amazon Landing Page
    When User Search for Product
    Then Verify Search Results
    And User Close Browser
