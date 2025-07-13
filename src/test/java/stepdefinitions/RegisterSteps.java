package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.*;

public class RegisterSteps {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    SignupPage signupPage = new SignupPage(driver);
    AccountInfoPage accountInfoPage = new AccountInfoPage(driver);
    AccountCreatedPage createdPage = new AccountCreatedPage(driver);
    AccountDeletedPage deletedPage = new AccountDeletedPage(driver);

    Faker faker = new Faker();
    String randomName = faker.name().firstName();
    String randomEmail = faker.internet().emailAddress();

    @Given("User is on the Home page")
    public void user_is_on_home_page() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    @When("User clicks on the Signup/Login link")
    public void user_clicks_signup_login() {
        homePage.clickSignupLogin();
    }

    @When("User enters a new name and unique email address")
    public void user_enters_name_email() {
        signupPage.enterName(randomName);
        signupPage.enterEmail(randomEmail);
    }

    @When("User clicks on the Signup button")
    public void user_clicks_signup_button() {
        signupPage.clickSignupButton();
    }

    @When("User fills in account information with personal and address details")
    public void user_fills_account_info() {
        accountInfoPage.selectTitleMr();
        accountInfoPage.enterPassword("Test@123");
        accountInfoPage.selectDOB("20", "September", "1999");
        accountInfoPage.checkNewsletter();
        accountInfoPage.checkSpecialOffers();

        accountInfoPage.enterFirstName(randomName);
        accountInfoPage.enterLastName(faker.name().lastName());
        accountInfoPage.enterCompany(faker.company().name());
        accountInfoPage.enterAddress1(faker.address().streetAddress());
        accountInfoPage.enterAddress2("");
        accountInfoPage.selectCountry("Canada");
        accountInfoPage.enterState(faker.address().state());
        accountInfoPage.enterCity(faker.address().city());
        accountInfoPage.enterZip(faker.address().zipCode());
        accountInfoPage.enterMobileNumber(faker.phoneNumber().cellPhone());
    }

    @When("User clicks the Create Account button")
    public void user_clicks_create_account_button() {
        accountInfoPage.clickCreateAccount();
    }

    @Then("A confirmation message {string} should be visible")
    public void confirmation_message_should_be_visible(String expectedMessage) {
        assert createdPage.isAccountCreatedVisible();
    }

    @When("User clicks the Continue button")
    public void user_clicks_continue_button() {
        createdPage.clickContinue();
    }

    @When("User deletes the account")
    public void user_deletes_account() {
        homePage.clickDeleteAccount(); // Must be implemented in HomePage
    }

    @Then("A confirmation message {string} should be visible again")
    public void account_deleted_message_should_be_visible(String expectedMessage) {
        assert deletedPage.isAccountDeletedVisible();
    }
}
