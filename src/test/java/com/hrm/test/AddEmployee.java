package com.hrm.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmployee {

    private static final By TXT_USERNAME = By.id("txtUsername");
    private static final By TXT_PASSWORD = By.id("txtPassword");
    private static final By BTN_LOGIN = By.id("btnLogin");
    private static final By MNU_PIM= By.id("menu_pim_viewPimModule");
    private static final By MNU_ADD_EMPLOYEE= By.id("menu_pim_addEmployee");
    private static final By TXT_FIRSTNAME= By.id("firstName");
    private static final By TXT_LASTNAME= By.id("lastName");
    private static final By TXT_EMP_ID= By.id("employeeId");
    private static final By PROFILE = By.id("photofile");
    private static final By BTN_SAVE = By.id("btnSave");
    private static final By CHK_LOGIN = By.id("chkLogin");
    private static final By LST_STATUS = By.id("status");
    private static final By TXT_LOGIN_USERNAME = By.id("user_name");
    private static final By TXT_LOGIN_PASSWORD = By.id("user_password");
    private static final By TXT_LOGIN_PASSWORD_CONFIRM = By.id("re_password");
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();

    }


    @BeforeMethod
    private WebDriver beforeMethod() {

        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        login();
        navigateToAddEmployeePage();
        return driver;
    }



    @AfterMethod
    private void afterMethod() {

        //driver.close();
    }

    @Test
    public void TestAddNewEmployeeWithMandatoryInfo() {
        driver.findElement(TXT_FIRSTNAME).sendKeys("Himashinee");
        driver.findElement(TXT_LASTNAME).sendKeys("Thennakoon");
        driver.findElement(PROFILE).sendKeys("H:\\Selenium training\\projects\\Training_1\\testData\\add34dae-1e95-4cc3-8a57-7021b30d9bcb.png");
        driver.findElement(BTN_SAVE).click();

    }

    @Test
    public void TestAddNewEmployeeWithLoginDetails() {
        driver.findElement(TXT_FIRSTNAME).sendKeys("Himashinee");
        driver.findElement(TXT_LASTNAME).sendKeys("Thennakoon");
        driver.findElement(CHK_LOGIN).click();
        driver.findElement(TXT_LOGIN_USERNAME).sendKeys("Himashinee1996");
        driver.findElement(TXT_LOGIN_PASSWORD).sendKeys("Ptl@#321");
        driver.findElement(TXT_LOGIN_PASSWORD_CONFIRM).sendKeys("Ptl@#321");
        driver.findElement(BTN_SAVE).click();

    }

    @Test
    public void TestAddNewEmployeeProfileImage() {
        driver.findElement(TXT_FIRSTNAME).sendKeys("Himashinee");
        driver.findElement(TXT_LASTNAME).sendKeys("Thennakoon");
        driver.findElement(BTN_SAVE).click();

    }

    private void login() {
        //Type the username
        driver.findElement(TXT_USERNAME).sendKeys("Admin");

        //Type the password
        driver.findElement(TXT_PASSWORD).sendKeys("Ptl@#321");

        //Click the login button
        driver.findElement(BTN_LOGIN).click();
    }

    private void navigateToAddEmployeePage() {
        //click the PIM menu
        driver.findElement(MNU_PIM).click();

        //click add employee menu
        driver.findElement(MNU_ADD_EMPLOYEE).click();


    }

}
