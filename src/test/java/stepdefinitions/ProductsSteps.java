package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import utilities.DriverFactory;

public class ProductsSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductPage productsPage = new ProductPage(driver);

    @When("User navigates to Products page")
    public void user_navigates_to_products_page() {
        homePage.clickProducts();
    }

    @Then("All products should be visible")
    public void all_products_should_be_visible() {
        Assert.assertTrue(productsPage.areProductsVisible());
    }

    @When("User clicks on View Product of any product")
    public void user_clicks_on_view_product() {
        productsPage.clickViewProduct();
    }

    @Then("Product detail page should be opened")
    public void product_detail_page_should_be_opened() {
        Assert.assertTrue(productsPage.isProductDetailVisible());
    }

    @When("User searches for product {string}")
    public void user_searches_for_product(String productName) {
        productsPage.searchForProduct(productName);
    }

    @Then("Searched product should be visible")
    public void searched_product_should_be_visible() {
        Assert.assertTrue(productsPage.isSearchedProductVisible());
    }
}
