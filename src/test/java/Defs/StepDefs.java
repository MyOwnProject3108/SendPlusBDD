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

    Resendactivationemail resendActivation = new Resendactivationemail();
    Base base = new Base();
   SignUpPage signUpPage = new SignUpPage();
    LoginPage loginPage = new LoginPage();
    Incoming incoming = new Incoming();

    String fullRandomEmailGenerated;


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
        signUpPage.signUp(firstName,surName,email,password,confirmpassword);
    }



    @Then("^I should be on the \"(.*?)\" page$")
    public void i_should_be_on_the_page(String page) throws Throwable {

            base.verifyUrlText(page);

    }


    @When("^I login with the below details$")
    public void i_login_with_the_below_details(DataTable arg1) throws Throwable {
        List<List<String>> data = arg1.raw();
        String username = data.get(1).get(0);
        String password =data.get(1).get(1);

        loginPage.login(username, password);
    }

    @Then("^I should see error message \"(.*?)\" on the login page$")
    public void i_should_see_error_message_on_the_login_page(String msg) throws Throwable {

        loginPage.verifyLoginFailedMsg(msg);

    }

    @Then("^I should see validation message \"(.*?)\" on the login page$")
    public void i_should_see_validation_message_on_the_login_page(String message) throws Throwable {
        loginPage.verifyValidationMsg(message);
    }


    @When("^I click on Sign-out")
    public void i_click_on_Sign_out() throws Throwable {
        incoming.signOut();

    }

    @When("^I select \"(.*?)\" transfers from the dropdown$")
    public void i_select_transfers_from_the_dropdown(String opt) throws Throwable {
        incoming.selectTransfers(opt);
    }


    @Then("^I should see \"(.*?)\" trasnfers$")
    public void i_should_see_trasnfers(String arg1) throws Throwable {
        incoming.verifyTransferStatus(arg1);
    }


    @Then("^I navigate to \"(.*?)\" page with random email \"(.*?)\"$")
    public void i_navigate_to_page_with_random_email(String page, String ranEmailText) throws Throwable {

          fullRandomEmailGenerated= signUpPage.generateRandom(ranEmailText);
         resendActivation.resendActivation(page, fullRandomEmailGenerated);

    }


    @Then("^I click on \"(.*?)\" link$")
    public void i_click_on_link(String arg1) throws Throwable {
        resendActivation.activationEmailLinkClick(arg1);
    }


    @Then("^I should see \"(.*?)\"$")
    public void i_should_see(String text) throws Throwable {
        resendActivation.verifyText(text);

    }

    @After
    public void stop(){
        System.out.println("After hook-----------------------------------");
        base.closeBrowser();
    }
}
