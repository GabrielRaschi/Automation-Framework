package com.carrefour_online.tests;
import AutomationFramework.DataItems;
import PageObjects.MainPage;
import com.carrefour_online.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class MainpageTest extends DriverBase {

    @Test
            (groups = "Test")
    public void SearchAndEdit() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Searching for a product and adding items to the cart...", "SearchAndAdd", DataItems.validUsername, DataItems.validPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.Search("apa");

        AssertJUnit.assertTrue("Wrong page accessed...", driver.getTitle().equals(DataItems.homepageTitle));
    }
}
