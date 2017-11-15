package PageObjects;

import org.openqa.selenium.By;

/**
 * Created by Faiyyaz.Shaik on 11/9/2017.
 */
public class Navigation extends Base{

    public static By openEmailElement = By.xpath("//div[contains(text(), 'Please verify your email to finish setting up your account.')]");


    public void openEmail() {
        getDriver().findElement(openEmailElement).click();


    }

    public void clickAuthenticate(String arg1) throws InterruptedException {

        getDriver().switchTo().frame("msg_body");
        getDriver().findElement(By.linkText(arg1)).click();


    }


}
