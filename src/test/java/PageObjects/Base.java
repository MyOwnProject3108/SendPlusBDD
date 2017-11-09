package PageObjects;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Base {

    public static WebDriver driver;



    public void initialise(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    public WebDriver getDriver()
    {

        return driver;
    }


    public void closeBrowser() {

        driver.quit();

    }



    public void verifyUrlText(String text){
        boolean textPresent = getDriver().getCurrentUrl().contains(text);
        Assert.assertTrue(textPresent);
    }



}
