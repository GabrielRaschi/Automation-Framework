package PageObjects;

import AutomationFramework.DataItems;
import AutomationFramework.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static AutomationFramework.Wait.clickable;

/**
 * Created by azaharia on 24.10.2016.
 */
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
    public WebElement missingFirstNameField;

    @FindBy(css = "#register > div > div:nth-child(2) > input")
    public WebElement lastNameField;

    @FindBy(css = "#register > div > div:nth-child(1) > div > span")
    public WebElement missingLastNameField;

    @FindBy(css = "#register > div > div:nth-child(3) > input")
    public WebElement emailFieldNewAcc;

    @FindBy(css = "#register > div > div:nth-child(4) > input")
    public WebElement phoneNumberField;

    @FindBy(css = "#register > div > div:nth-child(1) > div > span")
    public WebElement missingPhoneNumberField;

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


    // ---------- Logged user menu

    @FindBy(css = "body > div > header > nav > div.navbar-menu.navbar-column > ul > li.dropdown.login-user.ng-scope.open > div.dropdown-menu.dropdown-account.ng-scope > ul > div > li.last.ng-scope > a > span")
    public WebElement logoutLocator;





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










}

