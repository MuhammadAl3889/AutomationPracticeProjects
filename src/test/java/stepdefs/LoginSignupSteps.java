package stepdefs;

import factory.PageFactoryManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

public class LoginSignupSteps {

    WebDriver driver = Hooks.driver;
    PageFactoryManager factory = new PageFactoryManager(driver);
    HomePage home = factory.getHomePage();
    LoginPage login = factory.getLoginPage();
    SignupPage signup = factory.getSignupPage();

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        driver.get("https://automationexercise.com/");
    }

    @When("User navigates to Signup Login page")
    public void userNavigatesToSignupLoginPage() {
        home.clickSignupLogin();
    }

    @When("User enters name {string} and email {string} for signup")
    public void userEntersNameAndEmail(String name, String email) {
        signup.enterName(name);
        signup.enterEmail(email);
    }

    @When("User clicks Signup button")
    public void userClicksSignup() {
        signup.clickSignup();
    }

    @When("User enters login email {string} and password {string}")
    public void userEntersLoginCredentials(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @When("User clicks Login button")
    public void userClicksLogin() {
        login.clickLogin();
    }

    @Then("User should see login error")
    public void userShouldSeeLoginError() {
        Assert.assertTrue(login.isLoginErrorDisplayed());
    }

    @Then("User should be redirected to account information page")
    public void userShouldBeRedirectedToAccountInformationPage() {
        String currentUrl = driver.getCurrentUrl();
        boolean redirected = currentUrl.contains("signup") || currentUrl.contains("account_creation");

        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(redirected, "User was not redirected to account information page");
    }

}
