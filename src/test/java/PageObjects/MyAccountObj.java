package PageObjects;

import AutomationFramework.CommonTask;
import AutomationFramework.DataItems;
import AutomationFramework.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static AutomationFramework.Wait.clickable;
import static AutomationFramework.Wait.visible;


public class MyAccountPage extends MainPage{

    public MyAccountPage(WebDriver passedDriver) {
        super(passedDriver);
        PageFactory.initElements(passedDriver, this);
    }


    // -------------------------------- Locators

    // ---------- Login Form

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > div > ul > li:nth-child(1) > a")
    public WebElement loginFormTab;

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > div > ul > li.item.active > a")
    public WebElement loginFormTitle;

    @FindBy(name = "e-mail")
    public WebElement emailLoginField;

    @FindBy(name = "password")
    public WebElement passwordLoginField;

    @FindBy(name = "save-password")
    public WebElement rememberMeCheckbox;

    @FindBy(css = "#login > div > a")
    public WebElement forgotPasswordLink;

    @FindBy(css = "#login > div > button")
    public WebElement loginButton;


    // ---------- New Account Form

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > div > ul > li:nth-child(2) > a")
    public WebElement newAccountFormTab;

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > div > ul > li.item.active > a")
    public WebElement newAccountFormTabTitle;

    @FindBy(css = "#register > div > div:nth-child(1) > input")
    public WebElement firstNameField;

    @FindBy(css = "#register > div > div:nth-child(1) > div > span")
    public WebElement warningFirstNameField;

    @FindBy(css = "#register > div > div:nth-child(2) > input")
    public WebElement lastNameField;

    @FindBy(css = "#register > div > div:nth-child(1) > div > span")
    public WebElement warningLastNameField;

    @FindBy(css = "#register > div > div:nth-child(3) > input")
    public WebElement emailFieldNewAcc;

    @FindBy(css = "#register > div > div:nth-child(4) > input")
    public WebElement phoneNumberField;

    @FindBy(css = "#register > div > div:nth-child(1) > div > span")
    public WebElement warningPhoneNumberField;

    @FindBy(css = "#register > div > div:nth-child(6) > input")
    public WebElement passwordNewAccField;

    @FindBy(css = "#register > div > div:nth-child(7) > input")
    public WebElement confirmPasswordNewAccField;

    @FindBy(css = "#register > div > div:nth-child(8) > label > input")
    public WebElement termsAndCondCheckbox;

    @FindBy(css = "#register > div > div:nth-child(9) > label > input")
    public WebElement newsletterCheckbox;

    @FindBy(css = "#register > div > button")
    public WebElement submitNewAccButton;


    // -------------------- Logged user menu

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > ul > div > li:nth-child(1) > a")
    public WebElement myProfileMenuLocator;

    @FindBy(css = "body > div.page-container.ng-scope > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > ul > div > li:nth-child(3) > a")
    public WebElement shippingAdressMenuLocator;

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > ul > div > li.last.ng-scope > a > span")
    public WebElement logoutLocator;


    // --------------- myAccount Tabs

    @FindBy(css = "#my-profile-tab-head")
    public WebElement myProfileTab;

    @FindBy(css = "#my-addresses-tab-head")
    public WebElement shippingAdressTab;



    // --------- My Profile Tab

    @FindBy(css = "#my-profile > label:nth-child(2)")
    public WebElement editLastNameButton;

    @FindBy(id = "lastname")
    public WebElement lastNameEditField;

    @FindBy(xpath = "//div[@id='my-profile']/div/div/span")
    public WebElement warningEditLastNameLocator;


    @FindBy(css = "#my-profile > label:nth-child(4)")
    public WebElement editFirstNameButton;

    @FindBy(id = "firstname")
    public WebElement firstNameEditField;

    @FindBy(css = "#my-profile > div:nth-child(1) > div > span")
    public WebElement warningEditFirstNameLocator;


    @FindBy(css = "#my-profile > label:nth-child(6)")
    public WebElement editEmailAdressButton;

    @FindBy(id = "email")
    public WebElement emailAdressEditField;

    @FindBy(css = "#my-profile > div:nth-child(1) > div > span")
    public WebElement warningEditEmailLocator;


    @FindBy(css = "#my-profile > label:nth-child(8)")
    public WebElement editPhoneNumberButton;

    @FindBy(id = "phone")
    public WebElement editPhoneNumberField;

    @FindBy(css = "#my-profile > div:nth-child(1) > div > span")
    public WebElement warningEditPhoneNumberLocator;

    @FindBy(id = "masculin")
    public WebElement genderEditMale;

    @FindBy(id = "feminin")
    public WebElement genderEditFemaile;


    @FindBy(css = "#my-profile > label:nth-child(11)")
    public WebElement editDateOfBirtButton;

    @FindBy(css = "#my-profile > div:nth-child(10)")
    public WebElement editDateOfBirthField;


    @FindBy(css = "#my-profile > div:nth-child(13) > a")
    public WebElement showPassFieldsLocator;


    @FindBy(id = "oldPassword")
    public WebElement oldPasswordField;

    @FindBy(id = "password")
    public WebElement newPasswordField;

    @FindBy(id = "confirm_password")
    public WebElement confirmNewPasswordField;


    @FindBy(css = "#my-profile > div:nth-child(13) > button")
    public WebElement saveProfileButton;


    // ---------  Shipping Address Tab

    // --- Tab locators

    @FindBy(css = "#my-addresses > ul > li > div > div:nth-child(1) > h2")
    public WebElement addressNameOnTab;

    @FindBy(css = "#my-addresses > ul > li > div > div:nth-child(1) > p")
    public WebElement shippingDataOnTab;

    @FindBy(css = "#my-addresses > div > a > span.text-button.ng-binding")
    public WebElement newShippingAddressButton;

    @FindBy(css = "#my-addresses > ul > li:nth-child(1) > div > div.item.right > a.account-link.edit-button.ng-binding")
    public WebElement editShippingAddressButton;

    // --- Ship Address form

    @FindBy(id = "addressName")
    public WebElement shdAddressNameField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(1) > div > span")
    public WebElement warningAddressNameSh;

    @FindBy(id = "streetName")
    public WebElement shStreetNameField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(2) > div > span")
    public WebElement warningStreetNameFieldSh;

    @FindBy(id = "streetNo")
    public WebElement shStreeNoField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(3) > div > span")
    public WebElement warninggStreetNoFieldSh;

    @FindBy(id = "building")
    public WebElement shBuildingField;

    @FindBy(id = "buildingDoor")
    public WebElement shBuildingDoorField;

    @FindBy(id = "floor")
    public WebElement shFloorField;

    @FindBy(id = "apartment")
    public WebElement shApartmentField;

    @FindBy(id = "intercom")
    public WebElement shIntercomField;

    @FindBy(id = "zipCode")
    public WebElement shZipCodeField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(9) > div > span")
    public WebElement warningZipCodeSh;

    @FindBy(id = "district")
    public WebElement shDistrictField;

    @FindBy(css= "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(10) > div > span")
    public  WebElement warningDistrictSh;

    @FindBy(id = "city")
    public WebElement shCityField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(11) > div > span")
    public WebElement warningCity;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(12) > label > input")
    public WebElement shPersonOfContactMeRadiobutton;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(13) > label > input")
    public WebElement shPersonOfContactElseRadiobutton;

    @FindBy(id = "firstName")
    public WebElement shFirstNameField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div:nth-child(11) > div > span")
    public WebElement warningFirstNameSh;

    @FindBy(id = "lastName")
    public WebElement shLastNameField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div.ng-scope > div:nth-child(2) > div > span")
    public WebElement warningLastNameSh;

    @FindBy(id = "phone")
    public WebElement shPhoneNumberField;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div.ng-scope > div:nth-child(3) > div > span")
    public WebElement warningPhoneNumberSh;

    @FindBy(css = "body > div:nth-child(1) > div > div > div.modal-footer.ng-scope > button.btn.btn-primary.ng-binding")
    public WebElement shSaveButton;





    // -------------------------------- Methods

    public void loginWithUsernameAndPassword(String username, String pass){
        clickable(driver, myAccountLocator);
        myAccountLocator.click();
        clickable(driver, emailLoginField);
        emailLoginField.clear();
        emailLoginField.sendKeys(username);
        clickable(driver, passwordLoginField);
        passwordLoginField.clear();
        passwordLoginField.sendKeys(pass);
        loginButton.click();
    }

    public String getLabelNameFor(String field){
        String label = "";
        // --- Login Fields
        if (field.equals(DataItems.loginFormTabAndTitle[0])){
            Wait.visible(driver, loginFormTab);
            label = loginFormTab.getText();
        }
        else if (field.equals(DataItems.loginFormTabAndTitle[1])){
            Wait.visible(driver, loginFormTitle);
            label = loginFormTitle.getText();
        }
        else if (field.equals(DataItems.loginEmail[0])){
            Wait.visible(driver, emailLoginField);
            label = emailLoginField.getAttribute(DataItems.placeholder);
        }
        else if (field.equals(DataItems.loginPassword[0])) {
            Wait.visible(driver, passwordLoginField);
            label = passwordLoginField.getAttribute(DataItems.placeholder);
        }
        // --- New Acc Fields
        else if (field.equals(DataItems.newAccFormTabAndTitle[0])){
            Wait.visible(driver, newAccountFormTabTitle);
            label = newAccountFormTabTitle.getText();
        }
        else if (field.equals(DataItems.newAccFormTabAndTitle[1])) {
            Wait.visible(driver, newAccountFormTab);
            label = newAccountFormTab.getText();
        }
        else if (field.equals(DataItems.firstName[0])) {
            Wait.visible(driver, firstNameField);
            label = firstNameField.getAttribute(DataItems.placeholder);
        }
        else if (field.equals(DataItems.lastName[0])) {
            Wait.visible(driver, lastNameField);
            label = lastNameField.getAttribute(DataItems.placeholder);
        }
        else if (field.equals(DataItems.newAccEmail[0])) {
            Wait.visible(driver, emailFieldNewAcc);
            label = emailFieldNewAcc.getAttribute(DataItems.placeholder);
        }
        else if (field.equals(DataItems.phoneNumber[0])) {
            Wait.visible(driver, emailFieldNewAcc);
            label = phoneNumberField.getAttribute(DataItems.placeholder);
        }
        else if (field.equals(DataItems.newAccPassword[0])) {
            Wait.visible(driver, passwordNewAccField);
            label = passwordNewAccField.getAttribute(DataItems.placeholder);
        }
        else if (field.equals(DataItems.newAccConfirmPassword[0])) {
            Wait.visible(driver, confirmPasswordNewAccField);
            label = confirmPasswordNewAccField.getAttribute(DataItems.placeholder);
        }
        return label;
    }


    public void changePasswordForUser(String currentPass, String newPass){
        myProfileMenuLocator.click();
        showPassFieldsLocator.click();
        CommonTask.setInputField(driver, oldPasswordField, currentPass);
        CommonTask.setInputField(driver, newPasswordField, newPass);
        CommonTask.setInputField(driver, confirmNewPasswordField, newPass);
        saveProfileButton.click();
        myAccountLocator.click();
        visible(driver, logoutLocator);
        logoutLocator.click();
    }

    public void goToMyProfile(){
        clickable(driver, notificationLogin);
        myProfileMenuLocator.click();
        clickable(driver, myProfileTab);
        myProfileTab.click();
    }

    public void goToShippingAddress(){
        clickable(driver, notificationLogin);
        shippingAdressMenuLocator.click();
        clickable(driver, shippingAdressTab);
        shippingAdressTab.click();
    }



    public void inputMyProfileData(String lastname, String firstname, String email, String phone){
        editLastNameButton.click();
        CommonTask.setInputField(driver, lastNameEditField, lastname);
        editFirstNameButton.click();
        CommonTask.setInputField(driver, firstNameEditField, firstname);
        editEmailAdressButton.click();
        CommonTask.setInputField(driver, emailAdressEditField, email);
        editPhoneNumberButton.click();
        CommonTask.setInputField(driver, editPhoneNumberField, phone);
        if (genderEditMale.isSelected()){
            genderEditFemaile.click();
        }
        else genderEditMale.click();
        saveProfileButton.click();
    }

    public void inputShippingAddressData(String addressName, String streetName, String streetNo, String building, String buildingDoor, String floor, String apartment,
                                         String intercom, String  zipCode, String district, String city){
        try {
            clickable(driver, newShippingAddressButton);
            newShippingAddressButton.click();
        } catch (Exception e) {
        }
        CommonTask.setInputField(driver, shdAddressNameField, addressName);
        CommonTask.setInputField(driver, shStreetNameField, streetName);
        CommonTask.setInputField(driver, shStreeNoField, streetNo);
        CommonTask.setInputField(driver, shBuildingField, building);
        CommonTask.setInputField(driver, shBuildingDoorField, buildingDoor);
        CommonTask.setInputField(driver, shFloorField, floor);
        CommonTask.setInputField(driver, shApartmentField, apartment);
        CommonTask.setInputField(driver, shIntercomField, intercom);
        CommonTask.setInputField(driver, shZipCodeField, zipCode);
        CommonTask.setInputField(driver, shDistrictField, district);
        if (city.equals("")){
        }
        else CommonTask.setDropDownField(driver, shCityField, city);
    }

    public void inputUserDataForShippingAdress(String firstname, String lastname, String phone){
        CommonTask.setInputField(driver, shFirstNameField, firstname);
        CommonTask.setInputField(driver, shLastNameField, lastname);
        CommonTask.setInputField(driver, shPhoneNumberField, phone);
    }






}

