package testcases;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static utility.ReadConfig.getProperties;
import static utility.ReadJson.getUser;

public class LoginTest extends BaseClass {
    WebDriver driver;
    @Test(priority = 1)
    public void loginToSauce(){
        driver=getDriver();
        driver.get(getProperties().getProperty("url"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserName(getUser().username());
        loginPage.enterPassword(getUser().password());
        loginPage.login();
    }

    @Test(priority=2)
    public void logoutSauce(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOpenMenu();
        homePage.clickLogout();
    }
}
