Feature: Verify Languages are displaying correctly in Application

  Scenario: Verify that Default language is English on Amazon home page
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    And User Close Browser

Scenario: Verify that Clicking Hindi will change Default Language to Hindi
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Hindi"
    Then Verify Language Changed to "Hindi"
    And User Close Browser

 Scenario: Verify that Clicking Tamil will change Default Language to Tamil
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Tamil"
    Then Verify Language Changed to "Tamil"
    And User Close Browser

  Scenario: Verify that Clicking Telgu will change Default Language to Telgu
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Telgu"
    Then Verify Language Changed to "Telgu"
    And User Close Browser

  Scenario: Verify that Clicking Kannada will change Default Language to Kannada
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Kannada"
    Then Verify Language Changed to "Kannada"
    And User Close Browser

  Scenario: Verify that Clicking Malayalam will change Default Language to Malayalam
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Malayalam"
    Then Verify Language Changed to "Malayalam"
    And User Close Browser

 Scenario: Verify that Clicking Bangla will change Default Language to Bangla
   Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Bangla"
    Then Verify Language Changed to "Bangla"
    And User Close Browser

Scenario: Verify that Clicking Marathi will change Default Language to Marathi
    Given User is on Amazon Landing Page
    And Verify Default language is "English"
    When User Changes Default Language to "Marathi"
    Then Verify Language Changed to "Marathi"
    And User Close Browser