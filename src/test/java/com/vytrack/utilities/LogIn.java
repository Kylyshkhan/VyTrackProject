package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogIn {

    public static void crn_login(WebDriver driver, String username, String password){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
    }



    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}
