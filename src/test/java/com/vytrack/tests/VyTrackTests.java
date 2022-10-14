package com.vytrack.tests;

import Base.TestBase;
import org.openqa.selenium.Keys;
import utilities.Login;
import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VyTrackTests extends TestBase{
    /*AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.”
    when they click the “Vehicle Odometer” module.

            AC2: Drivers should see the default page as 1.

    AC3: Divers should see the View Per Page is 25 by default.

     */
    @Test (priority = 1)
    public void storeManager() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        Login.login_crm(driver, "salesmanager251", "UserUser123");

        Thread.sleep(5000);

        WebElement clickToFleet = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a)[1]"));
        clickToFleet.click();
        WebElement odometer = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        odometer.click();
        Thread.sleep(3000);
        WebElement message = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        String expected = "You do not have permission to perform this action.";
        String actual = message.getText();

        Assert.assertEquals(actual,expected);

        driver.quit();
    }
    @Test (priority = 2)
    public void salesManager() throws InterruptedException{
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("salesmanager251");
        Thread.sleep(3000);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123");
        Thread.sleep(3000);
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

    @Test (priority = 3)
    public void driverTest() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("user171");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123");
        WebElement clickToLogIn = driver.findElement(By.xpath("//button[@id='_submit']"));
        clickToLogIn.click();
        Thread.sleep(3000);


        WebElement fleetDropDown = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a)[1]"));
        fleetDropDown.click();

        Thread.sleep(1000);
        WebElement odometer = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        odometer.click();

        Thread.sleep(5000);
        int a = 1;
        WebElement defaultNumber = driver.findElement(By.xpath("//input[@value='1']"));
        defaultNumber.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        defaultNumber.sendKeys("1");
        Thread.sleep(2000);

        String expected = "1";
        String actual = defaultNumber.getAttribute("value");

       Assert.assertEquals(actual,expected);
       System.out.println("actual = " + actual);
       System.out.println("expected = " + expected);
        driver.quit();

    }
}
