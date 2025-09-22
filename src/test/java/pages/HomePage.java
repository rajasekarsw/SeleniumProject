package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//Button[text()=\"Open Menu\"]")
    private WebElement openMenu;

    @FindBy(css = "a#logout_sidebar_link")
    private WebElement logoutButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void  clickOpenMenu(){
        openMenu.click();
    }

    public void clickLogout(){
        logoutButton.click();
    }
}
