package com.carrefour_online.tests;

import AutomationFramework.DataItems;
import PageObjects.MyAccountObj;
import com.carrefour_online.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTests extends DriverBase {

    @Test
            (groups = "Test")
    public void L_01() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Login Validation 01 : Login with: empty, wrong, correct combinations of password and username", "L_V_01");

        MyAccountObj map = new MyAccountObj(driver);

        System.out.println("Login with empty username and pass and check notification");
        map.loginWithUsernameAndPassword("", "");
        AssertJUnit.assertTrue("Login is possible with empty username and password or notification is not proper", map.notificationText(DataItems.warning).equals(DataItems.wrongLoginMsg));

        System.out.println("Login with correct username and empty pass and check notification");
        map.loginWithUsernameAndPassword(DataItems.validUsername, "");
        AssertJUnit.assertTrue("Login is possible with empty username and password or notification is not proper", map.notificationText(DataItems.warning).equals(DataItems.wrongLoginMsg));

        System.out.println("Login with correct username and wrong pass and check notification");
        map.loginWithUsernameAndPassword(DataItems.validUsername, "wrong");
        AssertJUnit.assertTrue("Login is possible with empty username and password or notification is not proper", map.notificationText(DataItems.warning).equals(DataItems.wrongLoginMsg));

        System.out.println("Login with correct username and correct pass and check notification");
        map.loginWithUsernameAndPassword(DataItems.validUsername, DataItems.validPassword);
        AssertJUnit.assertTrue("Login is not successful or notification is not proper", map.notificationText(DataItems.login).equals(DataItems.correctLoginMsg));

        System.out.println("Logout and verify logout message");
        AssertJUnit.assertTrue("Logout notification is not proper", map.notificationText(DataItems.logout).equals(DataItems.correctLogoutMsg));
    }

    @Test
            (groups = "Test")
    public void L_02() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Login Validation 02 : Verify labels for login and new acc fields", "L_V_02");

        System.out.println("Verify labels for login form");
        MyAccountObj map = new MyAccountObj(driver);
        map.myAccountLocator.click();
        AssertJUnit.assertTrue("Label is not correct for login form tab", map.getLabelNameFor(DataItems.loginFormTabAndTitle[0]).equals(DataItems.loginFormTabAndTitle[2]));
        AssertJUnit.assertTrue("Label is not correct for login form title", map.getLabelNameFor(DataItems.loginFormTabAndTitle[1]).equals(DataItems.loginFormTabAndTitle[2]));
        AssertJUnit.assertTrue("Label is not correct for login login email field", map.getLabelNameFor(DataItems.loginEmail[0]).equals(DataItems.loginEmail[1]));
        AssertJUnit.assertTrue("Label is not correct for login login password field", map.getLabelNameFor(DataItems.loginPassword[0]).equals(DataItems.loginPassword[1]));

        System.out.println("Verify labels for new account form");
        map.newAccountFormTab.click();
        AssertJUnit.assertTrue("Label is not correct for new account form tab", map.getLabelNameFor(DataItems.newAccFormTabAndTitle[0]).equals(DataItems.newAccFormTabAndTitle[2]));
        AssertJUnit.assertTrue("Label is not correct for new account form title", map.getLabelNameFor(DataItems.newAccFormTabAndTitle[1]).equals(DataItems.newAccFormTabAndTitle[2]));
        AssertJUnit.assertTrue("Label is not correct for login first name field", map.getLabelNameFor(DataItems.firstName[0]).equals(DataItems.firstName[1]));
        AssertJUnit.assertTrue("Label is not correct for login last name field", map.getLabelNameFor(DataItems.lastName[0]).equals(DataItems.lastName[1]));
        AssertJUnit.assertTrue("Label is not correct for login new account email field", map.getLabelNameFor(DataItems.newAccEmail[0]).equals(DataItems.newAccEmail[1]));
        AssertJUnit.assertTrue("Label is not correct for login new account phone number field", map.getLabelNameFor(DataItems.phoneNumber[0]).equals(DataItems.phoneNumber[1]));
        AssertJUnit.assertTrue("Label is not correct for login new account password field", map.getLabelNameFor(DataItems.newAccPassword[0]).equals(DataItems.newAccPassword[1]));
        AssertJUnit.assertTrue("Label is not correct for login new account confirm password field", map.getLabelNameFor(DataItems.newAccConfirmPassword[0]).equals(DataItems.newAccConfirmPassword[1]));
    }

    @Test
            (groups = "Test")
    public void L_03() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Login Validation 03 : Verify that login is possible after password was changed", "L_V_03", DataItems.validUsername, DataItems.validPassword);

        System.out.println("Going to dashboard and changing password");




    }
}