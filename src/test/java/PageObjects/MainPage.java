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

    @FindBy(css = "body > div.ui-notification.ng-scope.warning > div")
    public WebElement notificationWarning;

    @FindBy(css = "body > div.ui-notification.ng-scope.success.killed > div")
    public WebElement notificationLogin;

    @FindBy(css = "body > div.ui-notification.ng-scope.info > div")
    public WebElement noticationLogout;


    public String notificationText(String typeOfNotif){
        MyAccountPage map = new MyAccountPage(driver);
        String notificationText = "";
        if (typeOfNotif.equals(DataItems.login)){
            myAccountLocator.click();
            Wait.visible(driver, notificationLogin);
            Wait.textPresent(driver, notificationLogin, DataItems.correctLoginMsg);
            notificationText = notificationLogin.getText();
        }
        else if (typeOfNotif.equals(DataItems.logout)){
            myAccountLocator.click();
            map.logoutLocator.click();
            Wait.visible(driver, noticationLogout);
            Wait.textPresent(driver, noticationLogout, DataItems.correctLogoutMsg);
            notificationText = noticationLogout.getText();
        }
        else if (typeOfNotif.equals(DataItems.warning)){
            Wait.visible(driver, notificationWarning);
            Wait.textPresent(driver, notificationWarning, DataItems.wrongLoginMsg);
            notificationText = notificationWarning.getText();
            driver.navigate().refresh();
            Wait.visible(driver, myAccountLocator);
        }
        return  notificationText;
    }





}
