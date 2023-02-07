Feature: Verify diffrent Filters on Search Results Page

#Scenario: Verify Default Filter Applied is Featured
#Given User is on Amazon Landing Page
#When User Search for Product
#Then Verify Default Sort By Feature
#  And User Close Browser
#
#Scenario Outline: Verify Filters Working Correctly
#Given User is on Amazon Landing Page
#When User Search for Product
#Then User Changes Filter To <filterValue> and Verify Results
#  And User Close Browser
#Examples:
#  |filterValue|
#  |Avg. Customer Review|
#  |Newest Arrivals     |
#  |Price Low To High   |
#  |Price High To Low   |
#
#Scenario Outline: Verify User able to sort items based on Given stars and Above
#Given User is on Amazon Landing Page
#When User Search for Product
#Then User Changes to <givenStars> stars & up and verify results
#  And User Close Browser
#  Examples:
#  |givenStars|
#  |4    |
#   |3   |
#  |2    |
#  |1    |

Scenario Outline: Verify User able to sort items based on Given Price Range
Given User is on Amazon Landing Page
When User Search for Product
Then User Changes to Given Price Range <givenPriceRange> and verify results
  And User Close Browser
  Examples:
    |givenPriceRange|
    |1    |
    |2   |
    |3    |
    |4    |
    |5    |

Scenario Outline: Verify User able to sort items based on Discount Categories
Given User is on Amazon Landing Page
When User Search for Product
  Then User Changes Discount Category to <discountCategory> and Verify Results
  And User Close Browser
  Examples:
    |discountCategory|
    |1         |
    |2         |
    |3         |
    |4         |
    |5         |
    |6         |

Scenario Outline: Verify User able to sort items based on Brands
Given User is on Amazon Landing Page
When User Search for Product
  Then User Changes Brands <brandNames> and Verify Results
  And User Close Browser
  Examples:
  |brandNames|
  |1         |
  |2         |
  |3         |
  |4         |
  |5         |
  |6         |
  |7         |