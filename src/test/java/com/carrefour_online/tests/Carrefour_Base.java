package com.carrefour_online.tests;
import AutomationFramework.DataItems;
import PageObjects.MyAccountObj;
import org.openqa.selenium.WebDriver;

public class Carrefour_Base {

    WebDriver driver;

    public Carrefour_Base(WebDriver passedDriver) {
        driver = passedDriver;
    }

    public void setUp(String testTitle, String scenarioID) {

        System.out.println("TEST: "+testTitle);
        System.out.println("Scenario ID: "+scenarioID);

        //Navigate to QA site
        System.out.println("Navigating to QA Environment...");
        driver.get(DataItems.targetURL);

        //Maximize browser window
        driver.manage().window().maximize();

        MyAccountObj map = new MyAccountObj(driver);
        map.closeButton.click();


    }

    public void setUp(String testTitle, String scenarioID, String username, String password) {

        System.out.println("TEST: "+testTitle);
        System.out.println("Scenario ID: "+scenarioID);

        //Navigate to QA site
        System.out.println("Navigating to Environment...");
        driver.get(DataItems.targetURL);

        //Maximize browser window
        driver.manage().window().maximize();

        MyAccountObj map = new MyAccountObj(driver);

        //Login with valid credentials
        map.loginWithUsernameAndPassword(username, password);

    }
}
