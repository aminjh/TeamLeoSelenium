package com.tests.natalya;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipkartSearchFunction extends TestBase {

    //Go to https://www.flipkart.com/
    //Locate Wire Headphones
    @Test
    public void flipkart_search_wiredHeadphones() {

        driver.get("https://www.flipkart.com/");
        try {
            if (driver.findElement(By.xpath("//div[@class='_3wFoIb row']")).isDisplayed()) {
                driver.findElement(By.xpath("//button[text()='✕']")).click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        WebElement electronics = driver.findElement(By.xpath("//div[.='Electronics']"));
        electronics.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).perform();

        WebElement wiredHeadphones = driver.findElement(By.linkText("Wired Headphones"));
        wiredHeadphones.click();

    }

    @Test
    public void flipkart_search_tshirts() {

        driver.get("https://www.flipkart.com/");
        try {
            if (driver.findElement(By.xpath("//div[@class='_3wFoIb row']")).isDisplayed()) {
                driver.findElement(By.xpath("//button[text()='✕']")).click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("t-shirts" + Keys.ENTER);

    }
}

