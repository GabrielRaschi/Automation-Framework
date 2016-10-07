package com.carrefour_online.tests;
import AutomationFramework.DataItems;
import PageObjects.LoginPage;
import com.carrefour_online.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTest extends DriverBase {

    @Test
            (groups = "Test")
    public void VerifyHomepage() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Verifying that the user accessed the correct homepage...", "VerifyHomepage");
        System.out.println("Checking that the user reach the correct landing page...");
        AssertJUnit.assertTrue("Wrong homepage...", driver.getTitle().equals(DataItems.homepageTitle));
    }

    @Test
            (groups = "Test")
    public void VerifyInvalidLogin() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Logging in with invalid credentials...", "VerifyInvalidLogin", DataItems.invalidUsername, DataItems.invalidPassword);
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("Checking that the user is on the login page...");
        AssertJUnit.assertTrue("Wrong page...", driver.getTitle().equals(DataItems.loginTitle));
        System.out.println("Checking that the error message is received...");
        AssertJUnit.assertTrue("Wrong page...", loginPage.errorMessage.getText().equals(DataItems.invalidLogin));
    }

    @Test
            (groups = "Test")
    public void LoginWithValid() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Logging in with valid credentials...", "LoginWithValid", DataItems.validUsername, DataItems.validPassword);
    }
}