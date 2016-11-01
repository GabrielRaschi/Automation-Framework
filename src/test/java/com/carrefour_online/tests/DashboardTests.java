package com.carrefour_online.tests;

import AutomationFramework.DataItems;
import AutomationFramework.Wait;
import PageObjects.MyAccountObj;
import com.carrefour_online.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.AssertTest;
import org.testng.annotations.Test;

public class DashboardTests extends DriverBase{

    @Test
            (groups = "Test")
    public void MP_01() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("My Space 01 : Save fields with changed data", "MP_01", DataItems.validUsername, DataItems.validPassword);

        MyAccountObj map = new MyAccountObj(driver);

        System.out.println("Going to my profile tab");
        map.goToMyProfile();
        AssertJUnit.assertFalse("Save button is clickable", map.saveProfileButton.isEnabled()); //MS_02 Test

        System.out.println("Changing profile data");
        map.inputMyProfileData(DataItems.myProfileData02[0], DataItems.myProfileData02[1], DataItems.myProfileData02[2], DataItems.myProfileData02[3]);
        AssertJUnit.assertTrue("Notification not present for update or text is wrong", map.notificationText(DataItems.updateProfile).equals(DataItems.userUpdateMsg));
        AssertJUnit.assertTrue("Dashboard name is not correct", map.myAccountLocator.getText().equals(DataItems.myProfileData02[1] + " " + DataItems.myProfileData02[0]));

        System.out.println("Changing profile data");
        map.inputMyProfileData(DataItems.myProfileData01[0], DataItems.myProfileData01[1], DataItems.myProfileData01[2], DataItems.myProfileData01[3]);
        AssertJUnit.assertTrue("Notification not present for update or text is wrong", map.notificationText(DataItems.updateProfile).equals(DataItems.userUpdateMsg));
        AssertJUnit.assertTrue("Dashboard name is not correct", map.myAccountLocator.getText().equals(DataItems.myProfileData02[1] + " " + DataItems.myProfileData02[0]));
    }

    @Test
            (groups = "Test")
    public void MP_03() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("My Profile 03 : Save empty fields", "MP_03", DataItems.validUsername, DataItems.validPassword);

        MyAccountObj map = new MyAccountObj(driver);

        System.out.println("Going to my profile tab");
        map.goToMyProfile();

        System.out.println("Clearing fields and save");
        map.inputMyProfileData("", "", "", "");

        System.out.println("Asserting proper msg is displayed for empty fields");
        Wait.clickable(driver, map.warningEditLastNameLocator);

        AssertJUnit.assertTrue("Message for empty blank space for Last Name is not correct", map.warningEditLastNameLocator.getText().equals(DataItems.blankFieldMsgForProfile));
        AssertJUnit.assertTrue("Message for empty blank space for First Name is not correct", map.warningEditFirstNameLocator.getText().equals(DataItems.blankFieldMsgForProfile));
        AssertJUnit.assertTrue("Message for empty blank space for email is not correct", map.warningEditEmailLocator.getText().equals(DataItems.blankFieldMsgForProfile));
        AssertJUnit.assertTrue("Message for empty blank space for phone number is not correct", map.warningEditPhoneNumberLocator.getText().equals(DataItems.blankFieldMsgForProfile));
    }

    @Test
            (groups = "Test")
    public void SA_01() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Shipping Address 01 : Validation for empty fields", "SA_01", DataItems.validUsername, DataItems.validPassword);

        MyAccountObj map = new MyAccountObj(driver);
        System.out.println("Going to my profile tab");
        map.goToShippingAddress();

        System.out.println("Clearing all fields");
        map.inputShippingAddressData("", "", "", "", "", "", "", "", "", "", "");
        map.shPersonOfContactElseRadiobutton.click();
        map.inputUserDataForShippingAddress("", "", "");
        map.shSaveButton.click();

        System.out.println("Asserting mandatory fields alerts");
        Wait.clickable(driver, map.warningAddressNameSh);
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for address name", map.warningAddressNameSh.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for street name", map.warningStreetNameFieldSh.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for street no", map.warninggStreetNoFieldSh.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for zip", map.warningZipCodeSh.getText().equals(DataItems.emptyZip));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for district", map.warningDistrictSh.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for city", map.warningCity.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for firstname", map.warningFirstNameSh.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for lastname", map.warningLastNameSh.getText().equals(DataItems.blankFieldMsgForShipping));
        AssertJUnit.assertTrue("Warning msg didn't show up or is incorrect for lastname", map.warningPhoneNumberSh.getText().equals(DataItems.blankFieldMsgForShipping));
        
    }

    @Test
            (groups = "Test")
    public void SA_02() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Shipping Address 02 : Add new adress flow is working correct", "SA_02", DataItems.validUsername, DataItems.validPassword);

        MyAccountObj map = new MyAccountObj(driver);
        System.out.println("Going to my profile tab");
        map.goToShippingAddress();

        System.out.println("Entering Shipping Data");
        map.inputShippingAddressData(DataItems.shippingAddressData01[0], DataItems.shippingAddressData01[1], DataItems.shippingAddressData01[2], DataItems.shippingAddressData01[3], DataItems.shippingAddressData01[4],
                DataItems.shippingAddressData01[5], DataItems.shippingAddressData01[6], DataItems.shippingAddressData01[7], DataItems.shippingAddressData01[8], DataItems.shippingAddressData01[9], DataItems.shippingAddressData01[10]);

        System.out.println("Saving Shipping Data");
        map.shSaveButton.click();
        Wait.clickable(driver, map.notificationShippingAddNew);

        System.out.println("Verify notification is present and msg is correct");
        AssertJUnit.assertTrue("Notification not present for update or text is wrong", map.notificationText(DataItems.addShppingAddress).equals(DataItems.addNewShippingAddressMsg));

        System.out.println("Verify that data is saved correctly");
        AssertJUnit.assertTrue("Data saved for address name is not correct", map.addressNameOnTab.getText().equals(DataItems.shippingAddressData01[0].toUpperCase()));
        AssertJUnit.assertTrue("Rest of the data that is saved for shipping adress is not correct", map.shippingDataOnTab.getText().equals(DataItems.shippingAddressData01[10] + ", " + DataItems.shippingAddressData01[9] + ", " + DataItems.shippingAddressData01[1] + ", " + DataItems.shippingAddressData01[0]));
    }

    @Test
            (groups = "Test")
    public void SA_03() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Shipping Address 03 : Edit test", "SA_03", DataItems.validUsername, DataItems.validPassword);

        MyAccountObj map = new MyAccountObj(driver);
        System.out.println("Going to my profile tab");
        map.goToShippingAddress();

        System.out.println("Adding new shipping address");
        map.inputShippingAddressData(DataItems.shippingAddressData01[0], DataItems.shippingAddressData01[1], DataItems.shippingAddressData01[2], DataItems.shippingAddressData01[3], DataItems.shippingAddressData01[4],
                DataItems.shippingAddressData01[5], DataItems.shippingAddressData01[6], DataItems.shippingAddressData01[7], DataItems.shippingAddressData01[8], DataItems.shippingAddressData01[9], DataItems.shippingAddressData01[10]);
        map.shSaveButton.click();
        Wait.clickable(driver, map.notificationShippingAddNew);

        System.out.println("Editing the shipping address that was added");
        map.editShippingAddressButton.click();
        map.inputShippingAddressData(DataItems.shippingAddressData02[0], DataItems.shippingAddressData02[1], DataItems.shippingAddressData02[2], DataItems.shippingAddressData02[3], DataItems.shippingAddressData02[4],
                DataItems.shippingAddressData02[5], DataItems.shippingAddressData02[6], DataItems.shippingAddressData02[7], DataItems.shippingAddressData02[8], DataItems.shippingAddressData02[9], DataItems.shippingAddressData02[10]);
        map.shSaveButton.click();
        Wait.clickable(driver, map.notificationShippingUpdate);

        System.out.println("Asserting correct data is saved after edit");

        AssertJUnit.assertTrue("Notification not present for update or text is wrong", map.notificationText(DataItems.updateShppingAddress).equals(DataItems.shippingAddressUpdateMsg));
        AssertJUnit.assertTrue("Data saved for address name is not correct", map.addressNameOnTab.getText().equals(DataItems.shippingAddressData02[0].toUpperCase()));
        AssertJUnit.assertTrue("Rest of the data that is saved for shipping address is not correct", map.shippingDataOnTab.getText().equals(DataItems.shippingAddressData02[10] + ", " + DataItems.shippingAddressData02[9] + ", " + DataItems.shippingAddressData02[1] + ", " + DataItems.shippingAddressData02[0]));
    }

    @Test
            (groups = "Test")
    public void SA_04() throws Exception {
        WebDriver driver = getDriver();

        Carrefour_Base base = new Carrefour_Base(driver);
        base.setUp("Shipping Address 04 : Delete test", "SA_04", DataItems.validUsername, DataItems.validPassword);

        MyAccountObj map = new MyAccountObj(driver);
        System.out.println("Going to my profile tab");
        map.goToShippingAddress();

        System.out.println("Adding new shipping address");
        map.inputShippingAddressData(DataItems.shippingAddressData01[0], DataItems.shippingAddressData01[1], DataItems.shippingAddressData01[2], DataItems.shippingAddressData01[3], DataItems.shippingAddressData01[4],
                DataItems.shippingAddressData01[5], DataItems.shippingAddressData01[6], DataItems.shippingAddressData01[7], DataItems.shippingAddressData01[8], DataItems.shippingAddressData01[9], DataItems.shippingAddressData01[10]);
        map.shSaveButton.click();
        Wait.clickable(driver, map.notificationShippingAddNew);

        System.out.println("Deleting Shipping Address");
        map.deleteShippingAddressButton.click();
        AssertJUnit.assertTrue("Notification not present for delete or text is wrong", map.notificationText(DataItems.deleteShippingAddress).equals(DataItems.deleteShippingAddressMsg));

    }



}
