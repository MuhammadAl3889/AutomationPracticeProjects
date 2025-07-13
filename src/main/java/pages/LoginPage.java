package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class LoginPage {
    private WebDriver driver;
    private WaitUtils wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//p[@style='color: red;']")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    private WebElement loginHeading;

    public void enterLoginEmail(String email) {
        wait.waitForVisibility(loginEmailInput).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        wait.waitForVisibility(loginPasswordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.waitForVisibility(loginButton).click();
    }

    public void clickLogout() {
        wait.waitForVisibility(logoutButton).click();
    }

    public String getLoginErrorMessage() {
        return wait.waitForVisibility(loginErrorMessage).getText();
    }

    public boolean isLoginPageVisible() {
        return wait.waitForVisibility(loginHeading).isDisplayed();
    }
}
