Feature: Verify Diffrent Pages of Application

Scenario: Verify that clicking all will display menu
Given User is on Amazon Landing Page
When User Opens Menu
Then Check Menu Opened Successfully
  And User Close Browser

Scenario: Verify that clicking Sell will open Sell page
Given User is on Amazon Landing Page
When User Opens "Sell" Page
Then Check "Sell" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Best Sellers will open Best Sellers page
Given User is on Amazon Landing Page
When User Opens "Best Sellers" Page
Then Check "Best Sellers" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Today's Deals will open Today's Deals page
Given User is on Amazon Landing Page
When User Opens "Today's Deals" Page
Then Check "Today's Deals" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Mobiles will open Mobiles page
Given User is on Amazon Landing Page
When User Opens "Mobiles" Page
Then Check "Mobiles" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Customer Service will open Customer Service page
Given User is on Amazon Landing Page
When User Opens "Customer Service" Page
Then Check "Customer Service" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Electronics will open Electronics page
Given User is on Amazon Landing Page
When User Opens "Electronics" Page
Then Check "Electronics" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Home & Kitchen will open Home & Kitchen page
Given User is on Amazon Landing Page
When User Opens "Home & Kitchen" Page
Then Check "Home & Kitchen" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Fashion open Fashion page
Given User is on Amazon Landing Page
When User Opens "Fashion" Page
Then Check "Fashion" Page Opened Successfully
And User Close Browser

Scenario: Verify that clicking Mini TV Banner open Mini TV Page
Given User is on Amazon Landing Page
And Opens Mini TV
Then Check Mini TV opened
And User Close Browser

Scenario: Verify that clicking Amazon Fresh Image open Amazon Fresh Page
Given User is on Amazon Landing Page
When User Opens Amazon Fresh Page
Then Check Amazon Fresh Page opened
And User Close Browser