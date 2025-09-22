package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    static private WebDriver driver;


    public static  WebDriver getDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");  // Run headless (required in CI)
        options.addArguments("--no-sandbox");    // Avoid sandboxing issues in containers
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Fix: unique user-data-dir so we don't hit "already in use"
        try {
            Path tempProfile = Files.createTempDirectory("chrome-profile");
            options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Could not create temp profile dir for Chrome", e);
        }



        if(driver==null) {
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    @AfterSuite
    public void tearDown(){
         if (driver!=null)
            driver.quit();
    }


}
