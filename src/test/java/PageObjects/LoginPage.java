package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginPage extends Base{

    private static By userName = By.xpath("//input[@placeholder='Email']");
    private static By pwd = By.xpath("//input[@placeholder='Password']");
    private static By signInForm = By.xpath("//button[@class='btn btn-primary']");
    private static By loginFailedMsg = By.xpath("//span[@class= 'ng-binding']");
    private static By userNameValidation = By.xpath("//div[@class='help-block']/span");


    public void login(String username, String password) throws InterruptedException {

        getDriver().findElement(userName).sendKeys(username);
        getDriver().findElement(pwd).sendKeys(password);
        getDriver().findElement(signInForm).click();
        Thread.sleep(10000);
    }

    public void verifyLoginFailedMsg(String expectedMsg){
        String actualMsg = getDriver().findElement(loginFailedMsg).getText();
        Assert.assertEquals(actualMsg, expectedMsg);
    }


    public void verifyValidationMsg(String message) {
        String actualMessage = getDriver().findElement(userNameValidation).getText();
        Assert.assertEquals(actualMessage,message);


    }

    public void ReLogin(String u, String p)throws InterruptedException{
        getDriver().findElement(userName).sendKeys(u);
        getDriver().findElement(pwd).sendKeys(p);
        getDriver().findElement(signInForm).click();
        Thread.sleep(10000);
    }
}
