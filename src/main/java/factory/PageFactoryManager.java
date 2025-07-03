package factory;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

public class PageFactoryManager {
    private final WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public SignupPage getSignupPage() {
        return new SignupPage(driver);
    }
}
