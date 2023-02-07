Feature: Verify SignIn Functionality of Application

Scenario: User must give email/phone number to proceed
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Click Continue Button
  And Verify Error message
  And User Close Browser

Scenario Outline: User should give correct email
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Enters incorrect email address <incorrectEmail>
  Then Verify Error Message for Incorrect Email
  When User Enters correct email address <correctEmail>
  Then Verify User is Navigated to Passwords Page
  And User Close Browser
  Examples:
  |incorrectEmail | correctEmail |
  |apple8788889   | apple@gmail.com |


Scenario Outline: User should give correct Phone Number
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When User Enters incorrect Phone Number <incorrectPhoneNumber>
  Then Verify Error Message for Incorrect Phone Number
  When Enters correct Phone Number <correctPhoneNumber>
  Then Verify User is Navigated to Passwords Page
  And User Close Browser
  Examples:
    |incorrectPhoneNumber | correctPhoneNumber |
    |12345   | 1234567890 |

Scenario Outline: User must give password to proceed
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When Enters correct Phone Number <correctPhoneNumber>
  Then Verify User is Navigated to Passwords Page
  When User Click Submit Button Error message should appear
  And User Close Browser
  Examples:
        | correctPhoneNumber |
       | 1234567890 |

Scenario Outline: User must give OTP to proceed
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When Enters correct Phone Number <correctPhoneNumber>
  Then Verify User is Navigated to Passwords Page
  When User Enters incorrect OTP <incorrectOTP> and Verify Error message
  And User Close Browser
  Examples:
    | correctPhoneNumber | incorrectOTP |
    | 1234567890 |  1234a                |

Scenario Outline: User should give correct Password
  Given User is on Amazon Landing Page
  And User Navigate to Sign In page
  When Enters correct Phone Number <correctPhoneNumber>
  Then Verify User is Navigated to Passwords Page
  When User Enters incorrect Password <incorrectPassword>
  Then Verify Error Message for Incorrect Password
  And User Close Browser
  Examples:
    | correctPhoneNumber | incorrectPassword |
    | 1234567890 |  123467                |