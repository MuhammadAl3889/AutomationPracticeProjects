package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        driver.get(ConfigReader.get("baseUrl"));
        homePage.clickSignupLogin();
    }

    @When("User enters a valid email and password")
    public void user_enters_valid_email_and_password() {
        String email = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
    }

    @When("User clicks the Login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in and see {string}")
    public void user_should_be_logged_in(String expectedText) {
        Assert.assertTrue(homePage.isLoggedInTextVisible(expectedText), "Login confirmation text not visible.");
    }

    @When("User enters an invalid email and password")
    public void user_enters_invalid_credentials() {
        loginPage.enterLoginEmail("wronguser@example.com");
        loginPage.enterLoginPassword("wrongpass");
    }

    @Then("An error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedMessage);
    }

    @When("User clicks the Logout button")
    public void user_clicks_logout_button() {
        loginPage.clickLogout();
    }

    @Then("User should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Login page is not visible after logout.");
    }
}
