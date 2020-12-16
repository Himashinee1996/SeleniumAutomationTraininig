package com.hrm.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    private void beforeMethod() {

        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
    }

    @AfterMethod
    private void afterMethod() {

        //driver.close();
    }

    @Test
    public void testValidAdminLogin() {

        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Click the login button
        driver.findElement(By.id("btnLogin")).click();

        //Get the welcome message
        String msgWelcome = driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(msgWelcome, "Welcome Admin");


    }

    @Test
    public void testValidAdminLoginWithEnterKeyFromPassword() {

        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");


        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321" + Keys.ENTER);


        //Get the welcome message
        String msgWelcome = driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(msgWelcome, "Welcome Admin");


    }

    @Test
    public void testValidAdminLoginWithSubmit() {

        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");


        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();


        //Get the welcome message
        String msgWelcome = driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(msgWelcome, "Welcome Admin");

    }


    @Test
    public void testAdminLoginWithEmptyUsernameAndPassword() {

        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("");


        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("txtPassword")).submit();



        //Verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");

    }

    @Test
    public void testAdminLoginWithEmptyUsername() {

        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("");


        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        //Verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");

    }


    @Test
    public void testAdminLoginWithEmptyPassword() {

        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");


        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("txtPassword")).submit();

        //Verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Password cannot be empty");

    }


    @Test
    public void testAdminLoginWithInvalidPassword() {
        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("1235kl");
        driver.findElement(By.id("txtPassword")).submit();

        //Verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Invalid credentials");

    }

    @Test
    public void testAdminLoginWithInvalidUsername() {
        //Type the username
        driver.findElement(By.id("txtUsername")).sendKeys("User");

        //Type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        //Verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Invalid credentials");

    }

}
