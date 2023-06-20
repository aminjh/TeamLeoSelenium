package com.tests.farangez;


import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogOut {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.symund.com/index.php/apps/dashboard/");


    }

    @Test

    public void LogOutTest(){

        //WebElement logOutButton = driver.findElement(By.xpath());

    }

}
