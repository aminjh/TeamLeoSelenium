package com.tests.fara;


import com.utilities.ConfigurationReader;
import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DeleteFile {
    //User story:
    //As a user, I should be able to delete a file.

    //AC1:Verify users can delete a file after clicking the 3 dots.
    //     - Deleted file should be listed in the “Deleted files” page. B29G24-27

    //AC2: Verify user can see the total number of files and folders under the files list table.
    //B29G24-31
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(ConfigurationReader.getProperty("env"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LogIn() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='user']"));
        userName.sendKeys("Employee20");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Employee123");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
    }

    @Test
    public void delete_a_file() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//input[@id='user']"));
        userName.sendKeys("Employee20");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Employee123");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        WebElement folders = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
        folders.click();

        Thread.sleep(2000);

        WebElement threeDots = driver.findElement(By.xpath("//a[@class='action action-menu permanent']"));
        threeDots.click();

        Thread.sleep(2000);


        driver.findElement(By.xpath("//a[@data-action='Delete']")).click();

        Thread.sleep(2000);

    }


    //@AfterMethod
    //public void tearDownMethod(){
    //driver.quit();
}



