package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signupLogin = By.xpath("//a[contains(text(),'Signup / Login')]");

    public void clickSignupLogin() {
        driver.findElement(signupLogin).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
