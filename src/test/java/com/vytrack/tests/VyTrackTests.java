package com.vytrack.tests;

import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VyTrackTests {
    /*AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.”
    when they click the “Vehicle Odometer” module.

            AC2: Drivers should see the default page as 1.

    AC3: Divers should see the View Per Page is 25 by default.

     */
    WebDriver driver;

    @Test (priority = 1)
    public void storeManager() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("storemanager83");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123");

        WebElement clickToLogIn = driver.findElement(By.xpath("//button[@id='_submit']"));
        clickToLogIn.click();

        Thread.sleep(5000);

        WebElement clickToFleet = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a)[1]"));
        clickToFleet.click();
        WebElement odometer = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        odometer.click();

        WebElement message = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        String expected = "You do not have permission to perform this action.";
        String actual = message.getText();

        Assert.assertEquals(actual,expected);

        driver.quit();
    }
}
