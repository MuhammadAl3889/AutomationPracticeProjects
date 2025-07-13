package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import utilities.DriverFactory;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickProceedToCheckout();
    }

    @Then("Address and Order summary should be displayed")
    public void address_and_order_summary_should_be_displayed() {
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible());
    }

    @When("User enters order comment and places the order")
    public void user_places_order_with_comment() {
        checkoutPage.enterComment("Please deliver soon.");
        checkoutPage.clickPlaceOrder();
    }

    @When("User fills payment details and confirms the order")
    public void user_fills_payment_details() {
        checkoutPage.enterPaymentInfo("Syed", "1234567812345678", "123", "12", "2025");
    }

    @Then("Order confirmation message should be shown")
    public void order_confirmation_should_be_shown() {
        Assert.assertTrue(checkoutPage.getSuccessMessage().contains("Your order has been placed successfully!"));
    }
}
