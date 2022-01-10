Feature: Check My Account Registration with valid and invalid credentials.

  @valid
  Scenario: Register with valid credentials
    Given User is on My Account Menu Page
    When  Enter registered Email Address in Email-Address textbox
    And   Enter your own password in password textbox
    And   Click on Register button
    Then  User will be registered successfully and will be navigated to the Home page
 @run
  Scenario: Register with Invalid Email id
    Given User is on My Account Menu Page
    When  Keep Empty Email-Address textbox
    And   Enter your own password in password textbox
    And   Click on Register button
    Then  Registration must fail with a warning message(ie You must enter a valid email address)
@invalid
  Scenario: Register with Invalid password
    Given User is on My Account Menu Page
    When   Enter Valid Email Address in Email-Address textbox
    And   Keep empty password textbox
    And   Click on Register button
    Then  Registration must fail with a warning message(ie please enter an account password)
@invalid
  Scenario: Register with Empty id and password
    Given User is on My Account Menu Page
    When   Keep Empty Email-Address textbox
    And   Keep empty password textbox
    And   Click on Register button
    Then  Registration must fail with a warning message(ie You must enter a valid email address)





