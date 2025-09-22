package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id="user-name")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUserName(String username){
        this.userName.sendKeys(username);
    }
    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void login(){
        loginButton.click();
    }

}
