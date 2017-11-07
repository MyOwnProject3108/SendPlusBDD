package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Faiyyaz.Shaik on 11/4/2017.
 */
public class Incoming extends Base {
    private static By userProf = By.xpath("//div[@class = 'user_name dropdown-toggle']");
    private static By signOutClick = By.xpath("//div[@class = 'btn btn-link']");
  //  private static By openDropdown = By.xpath("//div[@class = 'profile_wrapper dropdown open']");
            //"//div[@class='dropdown-menu']");

  //  private static By clickGetSupport = By.xpath("/div[@class = 'btn-container']/a[contains(text(), 'Get support')]");

  //  private static By clickSelectDropDown = By.xpath("//select[@ng-options = 'status.name for status in filters.statuses']");
      private static By clickSelectDropDown = By.xpath("//div[@class='filters']//select[@ng-model='status']");
    private static By verifyTransferStatus = By.xpath("//div[@class = 'transfer_progress_info row']//div[contains(text(), 'Received')]");



    public void signOut(){

        getDriver().findElement(userProf).click();
        getDriver().findElement(signOutClick).click();


    }

    public void selectTransfers(String arg1) throws InterruptedException {
        Select objSelect = new Select(getDriver().findElement(clickSelectDropDown));
        objSelect.selectByVisibleText(arg1);
    }


    public void verifyTransferStatus(String expectedStauts) {
        String actualStatus = getDriver().findElement(verifyTransferStatus).getText();
        Assert.assertEquals(actualStatus, expectedStauts);


    }
}








