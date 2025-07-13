package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utilities.DriverFactory;

public class TestCasesPageSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @When("User clicks on Test Cases link")
    public void user_clicks_test_cases_link() {
        homePage.clickTestCases();
    }

    @Then("User should be navigated to the Test Cases page")
    public void user_should_be_on_test_cases_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"));
    }
}
