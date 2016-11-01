package PageObjects;
import AutomationFramework.DataItems;
import AutomationFramework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static AutomationFramework.Wait.clickable;

public class MainPage {

    //Declare WebDriver
    protected static WebDriver driver;

    public MainPage(WebDriver passedDriver) {
        this.driver = passedDriver;
        PageFactory.initElements(passedDriver, this);
    }

    @FindBy(css = "#login-dropdown-toggle > span > span")
    public WebElement myAccountLocator;

    @FindBy(css = "#micro-cart-dropdown")
    public WebElement cartLocator;

    @FindBy(css = "#contact-dropdown > span")
    public WebElement contactLocator;

    @FindBy(css = "div > div > div > div.modal-header.ng-scope > button > span")
    public WebElement closeButton;


    // --------- Notifications

    @FindBy(css = "body > div.ui-notification.ng-scope.warning > div")
    public WebElement notificationWarning;

    @FindBy(css = "body > div.ui-notification.ng-scope.success.killed > div")
    public WebElement notificationLogin;

    @FindBy(css = "body > div.ui-notification.ng-scope.info > div")
    public WebElement noticationLogout;

    @FindBy(css = "body > div.ui-notification.ng-scope.success > div")
    public WebElement notificationUserUpdate;

    @FindBy(css = "body > div.ui-notification.ng-scope.info")
    public WebElement notificationShippingAddNew;

    @FindBy(css = "body > div.ui-notification.ng-scope.info.killed > div")
    public WebElement notificationShippingUpdate;

    @FindBy(css = "body > div.ui-notification.ng-scope.info.killed")
    public WebElement notificationShippingDelete;

    @FindBy(css = "body > div.ui-notification.ng-scope.info.killed > div")
    public WebElement notificationInvoiceAddNew;



    public String notificationText(String typeOfNotif) {
        MyAccountObj map = new MyAccountObj(driver);
        String notificationText = "";
        if (typeOfNotif.equals(DataItems.login)) {
            myAccountLocator.click();
            Wait.visible(driver, notificationLogin);
            Wait.textPresent(driver, notificationLogin, DataItems.correctLoginMsg);
            notificationText = notificationLogin.getText();
        } else if (typeOfNotif.equals(DataItems.logout)) {
            myAccountLocator.click();
            map.logoutLocator.click();
            Wait.visible(driver, noticationLogout);
            Wait.textPresent(driver, noticationLogout, DataItems.correctLogoutMsg);
            notificationText = noticationLogout.getText();
        } else if (typeOfNotif.equals(DataItems.warning)) {
            Wait.visible(driver, notificationWarning);
            Wait.textPresent(driver, notificationWarning, DataItems.wrongLoginMsg);
            notificationText = notificationWarning.getText();
            driver.navigate().refresh();
            Wait.visible(driver, myAccountLocator);
        } else if (typeOfNotif.equals(DataItems.updateProfile)) {
            Wait.visible(driver, notificationUserUpdate);
            Wait.textPresent(driver, notificationUserUpdate, DataItems.userUpdateMsg);
            notificationText = notificationUserUpdate.getText();
        }else if (typeOfNotif.equals(DataItems.addShppingAddress)) {
            Wait.visible(driver, notificationShippingAddNew);
            Wait.textPresent(driver, notificationShippingAddNew, DataItems.addNewShippingAddressMsg);
            notificationText = notificationShippingAddNew.getText();
        } else if (typeOfNotif.equals(DataItems.updateShppingAddress)) {
            Wait.visible(driver, notificationShippingUpdate);
            Wait.textPresent(driver, notificationShippingUpdate, DataItems.shippingAddressUpdateMsg);
            notificationText = notificationShippingUpdate.getText();
        } else if (typeOfNotif.equals(DataItems.deleteShippingAddress)) {
            Wait.visible(driver, notificationShippingDelete);
            Wait.textPresent(driver, notificationShippingDelete, DataItems.deleteShippingAddressMsg);
            notificationText = notificationShippingDelete.getText();
        } else if (typeOfNotif.equals(DataItems.addInvoice)) {
            Wait.visible(driver, notificationInvoiceAddNew);
            Wait.textPresent(driver, notificationInvoiceAddNew, DataItems.deleteInvoiceMsg);
            notificationText = notificationInvoiceAddNew.getText();
        }


        return notificationText;
    }


}
