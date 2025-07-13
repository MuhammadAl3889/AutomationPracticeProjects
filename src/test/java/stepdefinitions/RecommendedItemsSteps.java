package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.RecommendedItemsPage;
import utilities.DriverFactory;

public class RecommendedItemsSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    RecommendedItemsPage recommendedItemsPage = new RecommendedItemsPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Given("User scrolls to bottom of the Home page")
    public void user_scrolls_to_bottom_of_the_home_page() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Optional: wait for lazy load animations
        try {
            Thread.sleep(2000); // Replace with WebDriverWait if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Recommended items section is visible")
    public void recommended_items_section_is_visible() {
        Assert.assertTrue(recommendedItemsPage.isRecommendedSectionVisible(), "Recommended section not visible.");
    }

    @When("User adds a recommended product to the cart")
    public void user_adds_a_recommended_product_to_the_cart() {
        recommendedItemsPage.addRecommendedProductToCart();
    }

    @When("User clicks View Cart")
    public void user_clicks_view_cart() {
        recommendedItemsPage.clickViewCart();
    }

    @Then("The recommended product should be visible in the cart")
    public void recommended_product_should_be_visible_in_cart() {
        Assert.assertTrue(cartPage.isRecommendedProductVisible(), "Recommended product not found in cart.");
    }
}
