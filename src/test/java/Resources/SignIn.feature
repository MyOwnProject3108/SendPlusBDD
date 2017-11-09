Feature: Sendplus Signup or login functionality

  @registration
  Scenario: Verify user registration
    Given I am on the sendplus "https://app.sendplus.com/#/signup" page
    When I fill up the form with the following details
    |firstName|surName  |email     |password |confrimPassword|
    |qaFName  |qasurName|myownemail|you002   |you002         |
    Then I should be on the "confirmregistration" page


  @login
  Scenario: Verify valid user login
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
      When I login with the below details
      |username|password|
      |xmas@ad.com|abcdefghA1|
      Then I should be on the "resendactivationemail" page

  @loginActivation
  Scenario: Verify resendactivation
    Given I am on the sendplus "https://app.sendplus.com/#/signup" page
    When I fill up the form with the following details
      |firstName|surName  |email     |password |confrimPassword|
      |qaFName  |qasurName|myownemail|you002   |you002         |
    And I should be on the "confirmregistration" page
    And I navigate to "https://app.sendplus.com/#/confirmregistration/resendactivationemail/" page with random email
    And I should be on the "resendactivationemail" page
    And I click on "here" link
    Then I should be on the "confirmregistration" page



  @Invalidlogin
  Scenario: Verify error validation for invalid user login
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I login with the below details
      |username|password|
      |abc@ad.com|abcdefghA1|
    Then I should see error message "sorry, something went wrong" on the login page

  @errorvalidation
  Scenario: Verify error validation for missing username
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I login with the below details
      |username|password  |
      |        |abcdefghA1|
      Then I should see validation message "Required field" on the login page

    @signout
    Scenario: Verify valid user signout
      Given I am on the sendplus "https://app.sendplus.com/#/login" page
      When I login with the below details
        |username|password|
        |sendplus_qa1@adstream.com|Sendplus1|
      Then I should be on the "incoming" page
      When I click on Sign-out
      Then I should be on the "login" page

  @transfterstest
  Scenario:  Verify completed trasnfers
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I login with the below details
      |username|password|
      |sendplus_qa1@adstream.com|Sendplus1|
    Then I should be on the "incoming" page
    When I select "Completed" transfers from the dropdown
    Then I should see "Received" trasnfers
















