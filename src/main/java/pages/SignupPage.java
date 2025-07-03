package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private final WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameInput = By.name("name");
    private final By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[contains(text(),'Signup')]");

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }
}
