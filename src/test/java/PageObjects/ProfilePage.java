package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static AutomationFramework.CommonTask.setInputField;
import static AutomationFramework.Wait.clickable;

public class ProfilePage extends MainPage{

    @FindBy( xpath = "//*[@id=\"page\"]/header/div[2]/div/a/div/span")
    public WebElement profileButton;
    @FindBy( xpath = "//*[@id=\"page\"]/header/div[2]/div/div/ul/li/a")
    public WebElement profilePageButton;
    @FindBy( xpath = "//*[@id=\"page\"]/div/div/div[3]/div[1]/div[6]/a[1]")
    public WebElement editProfileButton;
    @FindBy( xpath = "//*[@id=\"profile_lastname\"]")
    public WebElement lastNameField;
    @FindBy( xpath = "//*[@id=\"profile_firstname\"]")
    public WebElement firstNameField;
    @FindBy( xpath = "//*[@id=\"profile_street\"]")
    public WebElement streetField;
    @FindBy( xpath = "//*[@id=\"profile_phone\"]")
    public WebElement phoneField;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[12]/div/div[1]/div[3]/div")
//    @FindBy( xpath = "//*[@id=\"form1\"]/div[12]/div/div[1]/div[3]/div/div[1]/span[2]")
    public WebElement cityButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[12]/div/div[1]/div[4]/div")
//    @FindBy( xpath = "//*[@id=\"form1\"]/div[12]/div/div[1]/div[4]/div/div[1]/span[2]")
    public WebElement zoneButton;
    @FindBy( xpath = "//*[@id=\"ucPrompt_profile_gender\"]/tbody/tr[1]/td/span/label")
    public WebElement femininButton;
    @FindBy( xpath = "//*[@id=\"ucPrompt_profile_gender\"]/tbody/tr[2]/td/span/label")
    public WebElement masculinButton;
    @FindBy( xpath = "//*[@id=\"profile_birthday_day\"]")
    public WebElement birthDayField;
    @FindBy( xpath = "//*[@id=\"profile_birthday_month\"]")
    public WebElement birthMonthField;
    @FindBy( xpath = "//*[@id=\"profile_birthday_year\"]")
    public WebElement birthYearField;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[12]/div/div[2]/a")
    public WebElement saveButton;
    @FindBy( xpath = "//*[@id=\"form1\"]/div[12]/div/a")
    public WebElement closeButton;

    public ProfilePage(WebDriver passedDriver) {
        super(passedDriver);
        PageFactory.initElements(passedDriver, this);
    }

    public void EnterProfilePage() {

        clickable(driver, profileButton);
        profileButton.click();
        clickable(driver, profilePageButton);
        profilePageButton.click();
    }

    public void EditProfile(String lastName, String firstName, String cityName, String zoneName, String streetName, String phone, WebElement gender, String day, String month, String year) {
        clickable(driver, editProfileButton);
        editProfileButton.click();
        System.out.println("Entering the last name...");
        setInputField(driver, lastNameField, lastName);
        System.out.println("Entering the first name...");
        setInputField(driver, firstNameField, firstName);

        clickable(driver, cityButton);
        cityButton.click();
        int nrCities = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[12]/div/div[1]/div[3]/div/div[2]/div/div/div[1]/ul/li")).size();
        for(int i=1; i<=nrCities; i++) {
            WebElement dropDownOption = cityButton.findElement(By.xpath("//*[@id=\"form1\"]/div[12]/div/div[1]/div[3]/div/div[2]/div/div/div[1]/ul/li[" + i + "]/a"));
            if (dropDownOption.getText().equalsIgnoreCase(cityName)) {
                System.out.println("Selecting the desired City...");
                clickable(driver, dropDownOption);
                dropDownOption.click();
                System.out.println("Desired city selected successfully...");
            }
        }

        clickable(driver, zoneButton);
        zoneButton.click();
        int nrZones = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[12]/div/div[1]/div[4]/div/div[2]/div/div/div[1]/ul/li")).size();
        for(int i=1; i<=nrZones; i++) {
            WebElement dropDownOption = zoneButton.findElement(By.xpath("//*[@id=\"form1\"]/div[12]/div/div[1]/div[4]/div/div[2]/div/div/div[1]/ul/li[" + i + "]/a"));
            if (dropDownOption.getText().equalsIgnoreCase(zoneName)) {
                System.out.println("Selecting the desired Zone...");
                clickable(driver, dropDownOption);
                dropDownOption.click();
                System.out.println("Desired zone selected successfully...");
            }
        }
        System.out.println("Entering the street name...");
        setInputField(driver, streetField, streetName);
        System.out.println("Entering the phone number...");
        setInputField(driver, phoneField, phone);
        System.out.println("Selecting the gender...");
        gender.click();
        System.out.println("Entering the birthday...");
        setInputField(driver, birthDayField, day);
        setInputField(driver, birthMonthField, month);
        setInputField(driver, birthYearField, year);
        System.out.println("Clicking the save button...");
        saveButton.click();
//        closeButton.click();
        driver.navigate().refresh();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
