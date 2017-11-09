package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;




public class Incoming extends Base {
    private static By userProf = By.xpath("//div[@class = 'user_name dropdown-toggle']");
    private static By signOutClick = By.xpath("//div[@class = 'btn btn-link']");
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








