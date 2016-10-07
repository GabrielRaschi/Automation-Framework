package PageObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy( css = "#page > header > div.blk.blk--abs.top-bar > div > a")
    public WebElement authButton;
    @FindBy( css = "#tf_keyword")
    public WebElement searchField;
    @FindBy( css = "#page > header > a")
    public WebElement carrefourLogo;
    @FindBy( xpath = "//*[@id=\"page\"]/header/div[1]/div[1]/span[2]")
    public WebElement shoppingListButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[1]/div/div[1]/a")
    public WebElement firstSearchedProduct;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[1]/div/div[3]/div[1]")
    public WebElement firstSearchedProductAddToCart;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[2]/div/div[1]/a")
    public WebElement secondSearchedProduct;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[2]/div/div[3]/div[1]")
    public WebElement secondSearchedProductAddToCart;


    public void Search(String product) {
        clickable(driver, searchField);
        searchField.sendKeys(product, Keys.ENTER);
        clickable(driver, firstSearchedProduct);
        firstSearchedProductAddToCart.click();
        clickable(driver, secondSearchedProduct);
        secondSearchedProductAddToCart.click();
        driver.navigate().refresh();
    }
}
