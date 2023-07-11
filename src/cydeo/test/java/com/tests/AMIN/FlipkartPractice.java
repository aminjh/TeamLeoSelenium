package cydeo.test.java.com.tests.AMIN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipkartPractice extends TestBase1 {

        @Test
        public void WiredHeadphones() {

            driver.get("https://www.flipkart.com/");
            if (

                    driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).isDisplayed()) {
                driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();


                WebElement electronics = driver.findElement(By.xpath("//div[.='Electronics']"));


                Actions actions = new Actions(driver);
                actions.moveToElement(electronics).perform();
                WebElement audio = driver.findElement(By.linkText("Audio"));

                actions.moveToElement(audio).perform();



                driver.findElement(By.linkText("Wired Headphones")).isDisplayed();
            }
        }
    }

