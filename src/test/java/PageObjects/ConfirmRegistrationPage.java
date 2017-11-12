package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConfirmRegistrationPage extends Base{

    private static By actualText = By.xpath("//div[@class = 'ng-scope']/p[1]");
  //  String text = "An authentication email has been sent to you, please click on the email link to confirm your address. If you do not receive the email, please check your junk mail folder.";

    public void verifyText(String text) {
        String actual = getDriver().findElement(By.xpath("//div[@class = 'ng-scope']/p[contains(text(), '"+text+"')]")).getText();

      //  String actual = getDriver().findElement(actualText).getText();
        Assert.assertEquals(actual, text);
    }


//    public void verifyMessageContent(String text) {
//
//    }
}
