package PageObjects;

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

    String randomEmailGenerated;
    String fullRandomEmailGenerated;





    public void navigateToSignUpPage(String url){

        getDriver().get(url);
    }


    public void signUp(String firstName, String surName1, String testEmail, String testPassword, String testConfirmpassword) throws InterruptedException {

        getDriver().findElement(fName).sendKeys(firstName+randomInt);
        getDriver().findElement(surName).sendKeys(surName1+randomInt);
         randomEmailGenerated = testEmail+randomInt;

        getDriver().findElement(email).sendKeys(randomEmailGenerated+ "@test.com");
        getDriver().findElement(password).sendKeys(testPassword);
        getDriver().findElement(confirmPassword).sendKeys(testConfirmpassword);
        getDriver().findElement(termsConf).click();
        Thread.sleep(10000);
        getDriver().findElement(submitForm).click();
        Thread.sleep(60000);


    }

    public String generateRandom(String ranEmail){

        fullRandomEmailGenerated = randomEmailGenerated+"@test.com";
        return fullRandomEmailGenerated;


    }



}
