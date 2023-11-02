package com.webstaurantstore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class base {
    public static WebDriver driver;
    public static void initialization(){
        WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.webstaurantstore.com/");

    }

    public void tearDown(){

        driver.quit();
    }

    public void waitForElement(WebElement locator){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}

