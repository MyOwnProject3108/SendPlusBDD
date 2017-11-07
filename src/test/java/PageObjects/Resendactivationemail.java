package PageObjects;


import junit.framework.Assert;
import org.openqa.selenium.By;

public class Resendactivationemail extends  Base {


    SignUpPage signUpPage = new SignUpPage();
    private static By actualText = By.xpath("//div[@class = 'ng-scope']/p[1]");


    public void resendActivation( String page, String fullRandomEmailGenerated) {

        getDriver().get(page + fullRandomEmailGenerated);


    }

    public void activationEmailLinkClick(String arg1) {
        getDriver().findElement(By.linkText(arg1)).click();


    }

    public void verifyText(String text) {

        String actual = getDriver().findElement(actualText).getText();
        Assert.assertEquals(actual, text);
    }
}
