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
    public void VerifyLandingPage() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Verifying that the user accessed the correct landing page...", "VerifyHomepage");
        System.out.println("Checking that the user reached the correct landing page...");
        outputToExcel("2", "1", "Navigate to the landing page", "Reached the correct landing page", "Failed");
        AssertJUnit.assertTrue("Wrong homepage...", driver.getTitle().equals(DataItems.homepageTitle));
        outputToExcel("2", "1", "Navigate to the landing page", "Reached the correct landing page", "Passed");
    }

    @Test
            (groups = "Test")
    public void VerifyInvalidLogin() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Logging in with invalid credentials...", "VerifyInvalidLogin", DataItems.invalidUsername, DataItems.invalidPassword);
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("Checking that the user is on the login page...");
        outputToExcel("3", "2", "Navigate to the login page", "Reached the correct login page", "Failed");
        AssertJUnit.assertTrue("Wrong page...", driver.getTitle().equals(DataItems.loginTitle));
        outputToExcel("3", "2", "Navigate to the login page", "Reached the correct login page", "Passed");
        System.out.println("Checking that the error message is received...");
        outputToExcel("4", "3", "Verify the correct error message", "Error message is correct", "Failed");
        AssertJUnit.assertTrue("Wrong page...", loginPage.errorMessage.getText().equals(DataItems.invalidLogin));
        outputToExcel("4", "3", "Verify the correct error message", "Error message is correct", "Passed");
    }

    @Test
            (groups = "Test")
    public void LoginWithValid() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Logging in with valid credentials...", "LoginWithValid", DataItems.validUsername, DataItems.validPassword);
        outputToExcel("5", "4", "Navigate to the homepage after logging in", "Reached the correct homepage", "Failed");
        AssertJUnit.assertTrue("Wrong homepage...", driver.getTitle().equals(DataItems.homepageTitle));
        outputToExcel("5", "4", "Navigate to the homepage after logging in", "Reached the correct homepage", "Passed");
    }
}