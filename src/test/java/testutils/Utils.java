package testutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Utils {

    public static WebElement checkInteractable(WebElement element, WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement checkVisibility(WebElement element,WebDriver driver){
        return new WebDriverWait(driver,Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

}
