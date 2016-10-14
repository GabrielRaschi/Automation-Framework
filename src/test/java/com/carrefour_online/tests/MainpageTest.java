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

    @Test
            (groups = "Test")
    public void AccessCategories() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Searching for a product and adding items to the cart...", "SearchAndAdd", DataItems.validUsername, DataItems.validPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.AccessCategoriesFromMenu(mainPage.promotii, mainPage.legumeSiFructeSubmenu);
        AssertJUnit.assertTrue("Wrong page accessed...", driver.getTitle().equals(DataItems.legumeSiFructeTitle));
        mainPage.AccessCategoriesFromMenu(mainPage.legumeSiFructe, mainPage.fructe);
        AssertJUnit.assertTrue("Wrong page accessed...", driver.getTitle().equals(DataItems.fructeTitle));
        mainPage.AccessCategoriesFromMenu(mainPage.brutarie, mainPage.panificatie);
        AssertJUnit.assertTrue("Wrong page accessed...", driver.getTitle().equals(DataItems.panificatieTitle));
        mainPage.AccessCategoriesFromMenu(mainPage.carneMezeluriSiLactate, mainPage.carneSiPeste);
        AssertJUnit.assertTrue("Wrong page accessed...", driver.getTitle().equals(DataItems.carneSiPesteTitle));
        mainPage.AccessCategoriesFromMenu(mainPage.bacanie, mainPage.dressing);
        AssertJUnit.assertTrue("Wrong page accessed...", driver.getTitle().equals(DataItems.dressingTitle));
    }
}
