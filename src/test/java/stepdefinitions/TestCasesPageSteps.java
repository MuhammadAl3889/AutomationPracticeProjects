package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.TestCasesPage;
import utilities.DriverFactory;

public class TestCasesPageSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    TestCasesPage testCasesPage = new TestCasesPage(driver);

    @When("User clicks on the Test Cases link")
    public void user_clicks_on_the_test_cases_link() {
        homePage.clickTestCases();  // Make sure this method exists in HomePage
    }

    @Then("The user should be navigated to the Test Cases page")
    public void the_user_should_be_navigated_to_the_test_cases_page() {
        String expectedUrl = "https://automationexercise.com/test_cases";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User is not on the Test Cases page.");
    }

    @Then("Test Cases content should be visible")
    public void test_cases_content_should_be_visible() {
        Assert.assertTrue(testCasesPage.isTestCasesContentVisible(), "Test Cases content is not visible.");
    }
}
