package Defs;

import PageObjects.*;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import java.util.List;



public class StepDefs{

    private String emailgenerated;


    Base base = new Base();
   SignUpPage signUpPage = new SignUpPage();
    LoginPage loginPage = new LoginPage();
    Incoming incoming = new Incoming();
    Navigation navigation = new Navigation();
    ConfirmRegistrationPage confirmRegistrationPage = new ConfirmRegistrationPage();




    @Before
    public void start(){
        System.out.println("Before hook-----------------------------------");
        base.initialise();


    }


    @Given("^I am on the sendplus \"(.*?)\" page$")
    public void i_am_on_the_sendplus_page(String url) throws Throwable {
        signUpPage.navigateToSignUpPage(url);

    }


    @When("^I fill up the form with the following details$")
    public void i_fill_up_the_form_with_the_following_details(DataTable arg1) throws Throwable {
        List<List<String>> data = arg1.raw();
        String firstName = data.get(1).get(0);
        String surName = data.get(1).get(1);
        String email = data.get(1).get(2);
        String password = data.get(1).get(3);
        String confirmpassword = data.get(1).get(4);
        emailgenerated = signUpPage.signUp(firstName,surName,email,password,confirmpassword);
    }


    @When("^I enter username \"(.*?)\" surName \"(.*?)\" email \"(.*?)\" password \"(.*?)\" and confirmPwd \"(.*?)\"$")
    public void i_enter_username_surName_email_password_and_confirmPwd(String fName, String surName, String email, String pass, String confPass) throws Throwable {
        signUpPage.signUpValidation(fName,surName,email,pass,confPass);
    }


    @Then("^I should be on the \"(.*?)\" page$")
    public void i_should_be_on_the_page(String page) throws Throwable {

            base.verifyUrlText(page);

    }



    @Then("^I should see error message \"(.*?)\" on the login page$")
    public void i_should_see_error_message_on_the_login_page(String msg) throws Throwable {

        loginPage.verifyLoginFailedMsg(msg);

    }

    @Then("^I should see validation message \"(.*?)\" on the login page$")
    public void i_should_see_validation_message_on_the_login_page(String message) throws Throwable {
        loginPage.verifyValidationMsg(message);
    }

    @Then("^I should see validation message \"(.*?)\" on the signup page$")
    public void i_should_see_validation_message_on_the_signup_page(String msg) throws Throwable {
        signUpPage.verifyValidationMsg(msg);
    }


    @When("^I click on Sign-out")
    public void i_click_on_Sign_out() throws Throwable {
        incoming.signOut();

    }

    @When("^I select \"(.*?)\" transfers from the dropdown$")
    public void i_select_transfers_from_the_dropdown(String opt) throws Throwable {
        incoming.selectTransfers(opt);
    }


    @Then("^I should see only \"(.*?)\" trasnfers$")
    public void i_should_see_only_trasnfers(String status) throws Throwable {
        incoming.verifyTransferStatus(status);
    }



    @Then("^I navigate to the random email Inbox")
    public void i_navigate_to_the_random_email_Inbox() throws Throwable {

        signUpPage.gotoRandomInbox(emailgenerated);
    }


    @When("^I SignIn with same random username \"(.*?)\" and password \"(.*?)\"$")
    public void i_SignIn_with_same_random_and_password(String uName, String password) throws Throwable {

       signUpPage.onLogin(uName,password);

    }

    @When("^I SignIn with username \"(.*?)\" and password \"(.*?)\"$")
    public void i_SignIn_with_and_password(String uName, String password) throws Throwable {

        loginPage.login(uName,password);

    }



    @Then("^I click on \"(.*?)\" link$")
    public void i_click_on_link(String arg1) throws Throwable {

        signUpPage.activationEmailLinkClick(arg1);
    }




    @When("^I should see \"(.*?)\"$")
    public void i_should_see(String text) throws Throwable {
        confirmRegistrationPage.verifyText(text);
    }



    @When("^I open the email$")
    public void i_open_the_email() throws Throwable {
        navigation.openEmail();
    }

    @When("^I click on \"(.*?)\" link on the page$")
    public void i_click_on_link_on_the_page(String arg1) throws Throwable {
        navigation.clickAuthenticate(arg1);
    }


    @When("^I should be navigated to \"(.*?)\" page$")
    public void i_should_be_navigated_to_page(String page) throws Throwable {
        base.navigateToPage(page);
    }


    @After
    public void stop(){
        System.out.println("After hook-----------------------------------");
        base.closeBrowser();
    }


}
