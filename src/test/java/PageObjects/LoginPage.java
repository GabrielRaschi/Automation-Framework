package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static AutomationFramework.Wait.*;

public class LoginPage extends MainPage{

    @FindBy( xpath = "//*[@id=\"content_0_txtEmail\"]")
    public WebElement usernameField;
    @FindBy( xpath = "//*[@id=\"content_0_txtPassword\"]")
    public WebElement passwordField;
    @FindBy( xpath = "//*[@id=\"content_0_btnLogin\"]")
    public WebElement loginButton;
    @FindBy( xpath = "//*[@id=\"page\"]/div[2]")
    public WebElement slider;
    @FindBy( xpath = "//*[@id=\"content_0_regEmail\"]")
    public WebElement errorMessage;

    public LoginPage(WebDriver passedDriver) {
        super(passedDriver);
        PageFactory.initElements(passedDriver, this);
    }

    public LoginPage loginWithUsernameAndPassword(String username, String password) {
        clickable(driver, usernameField);
        Actions typeUsernameAndPassword = new Actions(driver);
        typeUsernameAndPassword.sendKeys(usernameField, username).sendKeys(passwordField, password).click(loginButton).build().perform();
        clickable(driver, slider);
        return this;
    }
}