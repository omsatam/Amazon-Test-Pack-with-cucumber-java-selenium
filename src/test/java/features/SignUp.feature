Feature: Verify SignUp Functionality of Application

Scenario: Verify manadotory fields on Sign up page
  Given User is on Amazon Landing Page
  And User Navigate to Sign Up page
  Then Check all Manadotory Fields of SignUp page
  And User Close Browser

Scenario Outline: Verify User can write any characters in Name Field
  Given User is on Amazon Landing Page
  And User Navigate to Sign Up page
  When User Enters Name Field <name>
  Then Verify that User Navigated To Next Screen on Signup page
  And User Close Browser
  Examples:
  |name |
  |abcd |

  Scenario Outline: Verify User Enters Correct Phone Number on Sign Up page
    Given User is on Amazon Landing Page
    And User Navigate to Sign Up page
    When User User Enters Incorrect Phone Number <incorrectPhoneNumber> on Signup page then Error message should displayed
    Then User Enters Correct Phone Number <correctPhoneNumber>
    Then Verify that User Navigated To Next Screen on Signup page
    And User Close Browser
    Examples:
      |incorrectPhoneNumber | correctPhoneNumber |
      |abc   | 1234567890 |

@ignore
  Scenario Outline: Verify User Enters Correct Email Address on Sign Up page
    Given User is on Amazon Landing Page
    And User Navigate to Sign Up page
    When User User Enters Incorrect Email Address <incorrectEmail> on Signup page then Error message should displayed
    Then User Enters Correct Email Address <correctEmail>
    Then Verify that User Navigated To Next Screen on Signup page
    And User Close Browser
    Examples:
      |incorrectEmail | correctEmail |
      |apple8788889   | apple@gmail.com |


  Scenario Outline: Verify User Enters Correct Password on Sign Up page
    Given User is on Amazon Landing Page
    And User Navigate to Sign Up page
    When User Enters Incorrect Password <incorrectPassword> on Signup page then Error message should displayed
    Then User Enters Correct Password <correctPassword>
    Then Verify that User Navigated To Next Screen on Signup page
    And User Close Browser
    Examples:
      | correctPassword | incorrectPassword |
      | 1234567890 |  123                |