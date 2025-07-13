package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    @FindBy(xpath = "//ul[@id='address_delivery']")
    private WebElement addressDetails;

    @FindBy(name = "message")
    private WebElement orderCommentBox;

    @FindBy(xpath = "//a[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(name = "name_on_card")
    private WebElement nameOnCard;

    @FindBy(name = "card_number")
    private WebElement cardNumber;

    @FindBy(name = "cvc")
    private WebElement cvc;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    private WebElement expiryYear;

    @FindBy(id = "submit")
    private WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//p[contains(text(),'Your order has been placed successfully!')]")
    private WebElement successMessage;


    public boolean isAddressDetailsVisible() {
        return wait.waitForVisibility(addressDetails).isDisplayed();
    }

    public void enterComment(String comment) {
        wait.waitForVisibility(orderCommentBox).sendKeys(comment);
    }

    public void clickPlaceOrder() {
        wait.waitForVisibility(placeOrderButton).click();
    }

    public void enterPaymentInfo(String name, String card, String cvv, String month, String year) {
        wait.waitForVisibility(nameOnCard).sendKeys(name);
        cardNumber.sendKeys(card);
        cvc.sendKeys(cvv);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
        payAndConfirmOrderButton.click();
    }

    public String getSuccessMessage() {
        return wait.waitForVisibility(successMessage).getText();
    }
}
