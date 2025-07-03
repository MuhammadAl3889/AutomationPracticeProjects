package stepdefs;

import factory.PageFactoryManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class HomeSteps {
    WebDriver driver = Hooks.driver;
    PageFactoryManager factory = new PageFactoryManager(driver);
    HomePage homePage = factory.getHomePage();

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        driver.get("https://automationexercise.com/");
    }

    @Then("Title should contain {string}")
    public void titleShouldContain(String expected) {
        Assert.assertTrue(homePage.getTitle().contains(expected));
    }
}
