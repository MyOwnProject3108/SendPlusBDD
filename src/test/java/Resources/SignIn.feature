Feature: Sendplus Signup or login functionality

  @registration
  Scenario: Verify successful user registration
    Given I am on the sendplus "https://app.sendplus.com/#/signup" page
    When I fill up the form with the following details
    |firstName|surName  |email     |password |confrimPassword|
    |qaFName  |qasurName|myownemail|you002   |you002         |
    Then I should be on the "confirmregistration" page


  @login
  Scenario: Verify new user login
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I SignIn with username "xmas@ad.com" and password "abcdefghA1"
    Then I should be on the "resendactivationemail" page


  @transfterstest
  Scenario Outline:  Verify different trasnfers status
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I SignIn with username "sendplus_qa1@adstream.com" and password "Sendplus1"
    Then I should be on the "incoming" page
    When I select "<option>" transfers from the dropdown
    Then I should see only "<status>" trasnfers
    Examples:
      |option   |status|
      |Completed|Received|
      |Pending  |Pending |


   @LoginWithAuthentication
  Scenario:  Verify Authentication after signup
    Given I am on the sendplus "https://app.sendplus.com/#/signup" page
    When I fill up the form with the following details
      |firstName|surName  |email     |password |confrimPassword|
      |qaFName  |qasurName|myownemail|you002   |you002         |
      And I should be on the "confirmregistration" page
      And I navigate to the random email Inbox
      And I open the email
      And I click on "Authenticate my account" link on the page
      Then I should be navigated to "https://app.sendplus.com/#/confirmregistration/successful" page


  @loginwithoutAuthentication
  Scenario: Verify login without authentication
    Given I am on the sendplus "https://app.sendplus.com/#/signup" page
    When I fill up the form with the following details
      |firstName|surName  |email     |password |confrimPassword|
      |qaFName  |qasurName|myownemail|you002   |you002         |
    And I should be on the "confirmregistration" page
    And I should be navigated to "https://app.sendplus.com/#/login" page
    And I SignIn with same random username "myownemail" and password "you002"
    And I should be on the "resendactivationemail" page
    And I should see "User is not activated."
    And I click on "here" link
    Then I should be on the "confirmregistration" page

  @Invalidlogin
  Scenario: Verify error validation for invalid user login
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I SignIn with username "abc@ad.com" and password "abcdefghA1"
    Then I should see error message "sorry, something went wrong" on the login page


  @loginerrorvalidation
  Scenario Outline: Verify error validation for missing username/password for login page
    Given I am on the sendplus "https://app.sendplus.com/#/login" page
    When I SignIn with username "<username>" and password "<password>"
    Then I should see validation message "Required field" on the login page
    Examples:
      |username                         |password  |
      |                                 |abcdefghA1|
      |sendplus_qa1@adstream.com        |          |


    @signout
    Scenario: Verify valid user signout
      Given I am on the sendplus "https://app.sendplus.com/#/login" page
      When I SignIn with username "sendplus_qa1@adstream.com" and password "Sendplus1"
      Then I should be on the "incoming" page
      When I click on Sign-out
      Then I should be on the "login" page


      @signuperrorvalidation
      Scenario Outline: Verify error validation for missing firstName/surName for signup page
        Given I am on the sendplus "https://app.sendplus.com/#/signup" page
        When I enter username "<firstName>" surName "<surName>" email "<email>" password "<password>" and confirmPwd "<confirmPwd>"
        Then I should see validation message "<message>" on the signup page

      Examples:
          |firstName|surName  |email      |password |confirmPwd     |message|
          |         |qasurName| myownemail|you002   |you002         |Required field|
          |qaFNam   |         | myownemail|you002   |you002         |Required field|
          | qaFNam  |qasurName|           |you002   |you002         |Email is invalid|
          | qaFNam  |qasurName|myownemail | you0002 |you002         |The passwords do not match, please try again  |














































