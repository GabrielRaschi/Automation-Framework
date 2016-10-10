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
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[1]/div/div[3]/div[2]/span[2]")
    public WebElement firstSearchedProductPlusButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[2]/div/div[1]/a")
    public WebElement secondSearchedProduct;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[2]/div/div[3]/div[1]")
    public WebElement secondSearchedProductAddToCart;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[2]/div/div[3]/div[2]/span[2]")
    public WebElement secondSearchedProductPlusButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[3]/div/div[1]/a")
    public WebElement thirdSearchedProduct;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[3]/div/div[3]/div[1]")
    public WebElement thirdSearchedProductAddToCart;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[4]/div/ul/li[3]/div/div[3]/div[2]/span[2]")
    public WebElement thirdSearchedProductPlusButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[3]/div[2]/a")
    public WebElement clearSearchButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/footer/div/div/div[1]/a")
    public WebElement myCartButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_pnlRow_0\"]/div[3]/div/div[2]")
    public WebElement firstItemPlusButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_pnlRow_0\"]/div[3]/div/div[1]")
    public WebElement firstItemMinusButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_btnDelete_0\"]")
    public WebElement firstItemXButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_pnlRow_1\"]/div[3]/div/div[2]")
    public WebElement secondItemPlusButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_pnlRow_1\"]/div[3]/div/div[1]")
    public WebElement secondItemMinusButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_btnDelete_1\"]")
    public WebElement secondItemXButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_pnlRow_2\"]/div[3]/div/div[2]")
    public WebElement thirdItemPlusButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_pnlRow_2\"]/div[3]/div/div[1]")
    public WebElement thirdItemMinusButton;
    @FindBy( xpath = "//*[@id=\"content_0_repRapidDeliverable_btnDelete_2\"]")
    public WebElement thirdItemXButton;
    @FindBy( xpath = "//*[@id=\"content_0_lnk_delete\"]")
    public WebElement emptyCartButton;
    @FindBy( xpath = "//*[@id=\"ucPrompt_LinkButton1\"]")
    public WebElement confirmButton;
    @FindBy( xpath = "//*[@id=\"lnk_back\"]")
    public WebElement backButton;


    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Search(String product) {
        clickable(driver, searchField);
        searchField.sendKeys(product, Keys.ENTER);
        System.out.println("Add the first product...");
        clickable(driver, firstSearchedProduct);
        firstSearchedProductAddToCart.click();
        System.out.println("Added the first product...");
        clickable(driver, firstSearchedProductPlusButton);
        System.out.println("Waited for the button to appear...");
        System.out.println("Add the second product...");
        secondSearchedProductAddToCart.click();
        System.out.println("Added the second product...");
        System.out.println("Wait for the button to appear...");
        clickable(driver, secondSearchedProductPlusButton);
        System.out.println("Add the third product...");
        thirdSearchedProductAddToCart.click();
        System.out.println("Added the third product...");
        System.out.println("Wait for the button to appear...");
        clickable(driver, thirdSearchedProductPlusButton);
        System.out.println("Clear the search field...");
        clearSearchButton.click();
        clickable(driver, myCartButton);
        myCartButton.click();
        clickable(driver, firstItemPlusButton);
        firstItemPlusButton.click();
        firstItemPlusButton.click();
        firstItemPlusButton.click();
        firstItemMinusButton.click();
        secondItemPlusButton.click();
        secondItemPlusButton.click();
        secondItemMinusButton.click();
        thirdItemXButton.click();
        emptyCartButton.click();
        confirmButton.click();
        clickable(driver, backButton);
        backButton.click();
        clickable(driver, carrefourLogo);
    }
}
