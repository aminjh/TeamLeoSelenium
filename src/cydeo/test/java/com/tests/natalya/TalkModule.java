package com.tests.natalya;

import com.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TalkModule extends TestBase {

    // US:B29G24-10: As a user, I should be able to access to the Talk page.


    // TC B29G24-17: User successfully login to the Symund app
    @Test
    public void LoginWithValidDate() {

        // User go to the login page
        // Enter valid username/email
        // Enter valid password
        // Click the "Log in" button

        driver.get("https://qa.symund.com/index.php/apps/dashboard/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee80");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();
    }


    // TC B29G24-16:
    // AC1: Verify the app compress the app navigator by clicking the “app-navigation-toggle”.
    @Test
    public void accessTalkPage() {

        driver.get("https://qa.symund.com/index.php/apps/dashboard/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee80");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();

        // 1. user click "Talk" on the top panel
        // expected --> user can click "Talk" and go to the Talk page
        BrowserUtils.sleep(20);
        WebElement talkLink = driver.findElement(By.xpath("//ul[@id='appmenu']/li[@data-id='spreed']/a"));
        talkLink.click();

        // 2. user click “app-navigation-toggle”
        // expected --> user can click “app-navigation-toggle”
        WebElement appNavigationToggle = driver.findElement(By.xpath("//a[@aria-controls='app-navigation-vue']"));
        appNavigationToggle.isEnabled();

    }


    // TC B29G24-18
    // AC2: Verify user can send direct messagesVerify user can send direct messages.
    @Test
    public void sendDirectMessageToValidUser() {

        driver.get("https://qa.symund.com/index.php/apps/dashboard/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee80");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();
        BrowserUtils.sleep(20);
        WebElement talkLink = driver.findElement(By.xpath("//ul[@id='appmenu']/li[@data-id='spreed']/a"));
        talkLink.click();

        // 1. user type valid username in the "Search conversation or users" window
        // valid usernames: Zalina
        // expected --> user can type valid username and find it
        // 2. user click the found username
        // expected --> "You created the conversation" is displayed in the conversation field
        WebElement searchConversationOrUsersBox = driver.findElement(By.xpath("//input[@placeholder='Search conversations or users']"));
        searchConversationOrUsersBox.sendKeys("Zalina" + Keys.ENTER);

        driver.findElement(By.xpath("(//div[@class='rich-text--wrapper'])[1]")).isDisplayed();

        // 3. user type a message in "Write message .." window and click send icon
        // message: "Testing"
        // expected --> the message is displayed in the conversation field
        WebElement writeMessageBox = driver.findElement(By.xpath("//div[@placeholder='Write message, @ to mention someone …']"));
        writeMessageBox.click();
        writeMessageBox.sendKeys("Testing" + Keys.ENTER);

        String actualMessage = driver.findElement(By.xpath("(//div[@class='message__main__text'])[5]")).getText();
        String expectedMessage = "Testing";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    // TC B29G24-20
    // AC3: Verify user see the “You created the conversation!” Message after sending the first message.
    @Test
    public void sendFirstDirectMessageToValidUser() {
        driver.get("https://qa.symund.com/index.php/apps/dashboard/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee80");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();
        BrowserUtils.sleep(20);
        WebElement talkLink = driver.findElement(By.xpath("//ul[@id='appmenu']/li[@data-id='spreed']/a"));
        talkLink.click();

        // 1. user send the first message
        // expected --> user see the message “You created the conversation”

        WebElement searchConversationOrUsersBox = driver.findElement(By.xpath("//input[@placeholder='Search conversations or users']"));
        searchConversationOrUsersBox.sendKeys("Kadir" + Keys.ENTER);

        WebElement message = driver.findElement(By.xpath("//div[@class='message__main__text system-message']/div"));

        // 3. user type a message in "Write message .." window and click send icon
        // message: "Testing"
        // expected --> the message is displayed in the conversation field
        WebElement writeMessageBox = driver.findElement(By.xpath("//div[@placeholder='Write message, @ to mention someone …']"));
        writeMessageBox.click();
        writeMessageBox.sendKeys("First message" + Keys.ENTER);

        String actualMessage = driver.findElement(By.xpath("//div[@class='message__main__text system-message']/div")).getText();
        String expectedMessage = "You created the conversation";

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }


    // TC B29G24-41
    // AC4: Verify no matches are found when user type invalid username in the "Search conversations or users" box.
    @Test
    public void sendDirectMessageToInvalidUser() {

        driver.get("https://qa.symund.com/index.php/apps/dashboard/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
        System.out.println("username = " + username);
        username.sendKeys("Employee80");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys(Keys.ENTER + "Employee123");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        loginButton.click();
        BrowserUtils.sleep(20);
        WebElement talkLink = driver.findElement(By.xpath("//ul[@id='appmenu']/li[@data-id='spreed']/a"));
        talkLink.click();

        // 1. user type invalid username in the "Search conversations or users" box
        // invalid username: Haden
        // expected --> No matches are found

        WebElement searchConversationOrUsersBox = driver.findElement(By.xpath("//input[@placeholder='Search conversations or users']"));
        searchConversationOrUsersBox.sendKeys("Haden" + Keys.ENTER);

        String actualMessage = driver.findElement(By.xpath("//ul[@class='conversations']/li")).getText();
        Assert.assertTrue(actualMessage.contains("No matches"));
    }

}
