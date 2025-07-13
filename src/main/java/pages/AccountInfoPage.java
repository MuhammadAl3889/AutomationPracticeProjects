package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class AccountInfoPage {
    private WebDriver driver;
    private WaitUtils wait;

    public AccountInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    // Title
    @FindBy(id = "id_gender1")
    private WebElement titleMr;

    // Password
    @FindBy(id = "password")
    private WebElement passwordInput;

    // Date of Birth
    @FindBy(id = "days")
    private WebElement dayDropdown;

    @FindBy(id = "months")
    private WebElement monthDropdown;

    @FindBy(id = "years")
    private WebElement yearDropdown;

    // Checkboxes
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOfferCheckbox;

    // Address Info
    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileInput;

    // Submit button
    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    private WebElement createAccountButton;

    // ========== Actions ==========

    public void selectTitleMr() {
        wait.waitForVisibility(titleMr).click();
    }

    public void enterPassword(String password) {
        wait.waitForVisibility(passwordInput).sendKeys(password);
    }

    public void selectDOB(String day, String month, String year) {
        new Select(dayDropdown).selectByVisibleText(day);
        new Select(monthDropdown).selectByVisibleText(month);
        new Select(yearDropdown).selectByVisibleText(year);
    }

    public void checkNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    public void checkSpecialOffers() {
        if (!specialOfferCheckbox.isSelected()) {
            specialOfferCheckbox.click();
        }
    }

    public void enterFirstName(String firstName) {
        wait.waitForVisibility(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.waitForVisibility(lastNameInput).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        wait.waitForVisibility(companyInput).sendKeys(company);
    }

    public void enterAddress1(String address1) {
        wait.waitForVisibility(address1Input).sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        wait.waitForVisibility(address2Input).sendKeys(address2);
    }

    public void selectCountry(String country) {
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public void enterState(String state) {
        wait.waitForVisibility(stateInput).sendKeys(state);
    }

    public void enterCity(String city) {
        wait.waitForVisibility(cityInput).sendKeys(city);
    }

    public void enterZip(String zip) {
        wait.waitForVisibility(zipInput).sendKeys(zip);
    }

    public void enterMobileNumber(String mobile) {
        wait.waitForVisibility(mobileInput).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        wait.waitForVisibility(createAccountButton).click();
    }
}
