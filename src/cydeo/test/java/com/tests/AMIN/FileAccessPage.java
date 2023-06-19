package com.cydeo.tests.AMIN;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileAccessPage extends TestBase {
/*
    @Test
    public void LoginWithValidDate() {


        driver.get("https://qa.symund.com/index.php/apps/dashboard/");

        WebElement username = driver.findElement(By.xpath("//input[@name='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee10");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();
    }
*/
    @Test
    public void accessFilesPage() {

        driver.get("https://qa.symund.com/index.php/apps/dashboard/");

        WebElement username = driver.findElement(By.xpath("//input[@name='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee10");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();

        WebElement filesPage = driver.findElement(By.xpath("(//a[@aria-label='Files'])[1]"));
        filesPage.click();

    }
}