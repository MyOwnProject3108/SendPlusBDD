package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;


public class SignUpPage extends Base {
    public static Random random = new Random();
    int randomInt = random.nextInt(10000);


    private static By fName = By.xpath("//input[@placeholder='First Name']");
    private static By surName = By.xpath("//input[@placeholder='Surname']");
    private static By email = By.xpath("//input[@placeholder='Email']");
    private static By password = By.xpath("//input[@placeholder='Password']");
    private static By confirmPassword = By.xpath("//input[@placeholder='Password again']");
    private static By termsConf = By.xpath("//input[@type='checkbox']");
    private static By submitForm = By.xpath("//input[@value= 'Sign Up']");

    private static By signInForm = By.xpath("//button[@class='btn btn-primary']");
    private static By validationText = By.xpath("//span[@class= 'ng-binding']");

    public  String emailgenerated;







    public void navigateToSignUpPage(String url){

        getDriver().get(url);
    }


    public String signUp(String firstName, String surName1, String randomEmailGenerated, String testPassword, String testConfirmpassword) throws InterruptedException {

        getDriver().findElement(fName).sendKeys(firstName+randomInt);
        getDriver().findElement(surName).sendKeys(surName1+randomInt);
        testRandom(randomEmailGenerated);
        getDriver().findElement(password).sendKeys(testPassword);
        getDriver().findElement(confirmPassword).sendKeys(testConfirmpassword);
        getDriver().findElement(termsConf).click();
        Thread.sleep(10000);
        getDriver().findElement(submitForm).click();
        Thread.sleep(60000); //Sometimes Signup fails as it's known issue in S+ so I had to add sleep......

        return emailgenerated;


    }

    public void signUpValidation(String firstName, String surName1, String email1, String testPassword1, String testConfirmpassword1) throws InterruptedException {

        getDriver().findElement(fName).sendKeys(firstName);
        getDriver().findElement(surName).sendKeys(surName1);
        getDriver().findElement(email).sendKeys(email1 + "@mailinator.com");
        getDriver().findElement(password).sendKeys(testPassword1);
        getDriver().findElement(confirmPassword).sendKeys(testConfirmpassword1);
        getDriver().findElement(termsConf).click();
        Thread.sleep(10000);
        getDriver().findElement(submitForm).click();

    }



    public String testRandom(String randomEmail) {
        int randomInt = random.nextInt(100000);
       emailgenerated = randomEmail + randomInt;
       getDriver().findElement(email).sendKeys(emailgenerated+ "@mailinator.com");
        return emailgenerated;
    }

    public void onLogin(String uName, String testPassword) throws InterruptedException {


        getDriver().findElement(email).sendKeys(emailgenerated+ "@mailinator.com");
        getDriver().findElement(password).sendKeys(testPassword);
        getDriver().findElement(signInForm).click();
        Thread.sleep(10000);


    }

//    public void openEmail(String openEmailPage) {
//        getDriver().get(openEmailPage+ emailgenerated+"#"+"/"+"msgpane"+"#");
//        System.out.println(openEmailPage+ emailgenerated+"#"+"/"+"#"+"msgpane");
//
//
//    }


    public void resendActivation( String page, String emailgenerated) {

        getDriver().get(page + emailgenerated);


    }

    public void activationEmailLinkClick(String arg1) {
        getDriver().findElement(By.linkText(arg1)).click();


    }


    public void gotoRandomInbox(String emailgenerated) {

        getDriver().get("https://www.mailinator.com/v2/inbox.jsp?zone=public&query="+ emailgenerated);

    }


    public void verifyValidationMsg(String msg) {
        String actualMessage = getDriver().findElement(validationText).getText();
        Assert.assertEquals(actualMessage,msg);
    }
}
