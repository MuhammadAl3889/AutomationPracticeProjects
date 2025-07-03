package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private final By loginError = By.cssSelector(".login-form p");

    // Actions
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElement(loginError).isDisplayed();
    }
}
