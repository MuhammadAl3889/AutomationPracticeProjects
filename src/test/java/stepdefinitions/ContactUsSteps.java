package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.DriverFactory;

public class ContactUsSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @When("User clicks on the Contact Us link")
    public void user_clicks_on_contact_us_link() {
        homePage.clickContactUs();
    }

    @When("User fills the contact form with name, email, subject, and message")
    public void user_fills_contact_form_fields() {
        contactUsPage.fillContactForm("Syed Ali", "syed.ali@example.com", "Automation Inquiry", "Please contact me regarding automation services.");
    }

    @When("User clicks the Submit button")
    public void user_clicks_submit_button() {
        contactUsPage.clickSubmit();
        contactUsPage.acceptAlert();
    }

    @Then("A success message {string} should be displayed")
    public void success_message_should_be_displayed(String expectedMessage) {
        String actualMessage = contactUsPage.getSuccessMessage();
        System.out.println("Actual success message: " + actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message not found! Expected: " + expectedMessage + " but was: " + actualMessage);
    }

    @When("User clicks the Home button")
    public void user_clicks_home_button() {
        contactUsPage.clickHomeButton();
    }

    @Then("User should be redirected to the Home page")
    public void user_should_be_redirected_to_home_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/",
                "User was not redirected to the Home page.");
    }
}
