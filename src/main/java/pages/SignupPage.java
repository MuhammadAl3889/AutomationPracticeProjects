package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignupNameEmail(String name, String email) {
        try {
            driver.findElement(By.name("name")).sendKeys(name);
            driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
        } catch (Exception e) {
            System.out.println("Signup form error: " + e.getMessage());
        }
    }

    public void clickSignupButton() {
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
    }

    public void enterLoginEmailPassword(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
    }

    public void enterName(String name) {
        driver.findElement(By.name("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
    }
}
