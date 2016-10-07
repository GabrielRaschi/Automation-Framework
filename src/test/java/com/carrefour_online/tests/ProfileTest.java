package com.carrefour_online.tests;
import AutomationFramework.DataItems;
import PageObjects.ProfilePage;
import com.carrefour_online.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ProfileTest extends DriverBase {

    @Test
            (groups = "Test")
    public void EditProfileInformation() throws Exception {

        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Editing the information on the profile page...", "EditProfileInformation", DataItems.validUsername, DataItems.validPassword);

        ProfilePage profilePage = new ProfilePage(driver);
        System.out.println("Navigating to the profile page...");
        profilePage.EnterProfilePage();
        System.out.println("Modifying the information on the profile page...");
        profilePage.EditProfile("Doe", "Jane", "bucuresti", "bucuresti", "ale. str. blvd.", "0744123456", profilePage.femininButton, "10", "10", "1999");
        System.out.println("Modifying the information on the profile page...");
        profilePage.EditProfile("Doe", "John", "alba", "blaj", "blvd. carrefour", "0744000000", profilePage.masculinButton, "12", "12", "2000");
    }

}
