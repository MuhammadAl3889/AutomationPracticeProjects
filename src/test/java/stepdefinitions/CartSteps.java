package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductPage;
import utilities.DriverFactory;

public class CartSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProductPage productsPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("User adds product to cart and navigates to cart page")
    public void user_adds_product_to_cart() {
        productsPage.clickAddToCart();
        productsPage.clickViewCart();
    }

    @Then("Cart page should display correct product")
    public void cart_should_display_product() {
        Assert.assertTrue(cartPage.isCartNotEmpty());
    }

    @When("User increases quantity to {int}")
    public void user_increases_quantity_to(int qty) {
        cartPage.updateQuantity(qty);
    }

    @Then("Quantity should be updated in the cart")
    public void quantity_should_be_updated() {
        Assert.assertEquals(cartPage.getQuantity(), "4");
    }
}
