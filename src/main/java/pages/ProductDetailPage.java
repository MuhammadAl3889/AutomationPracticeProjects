package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class ProductDetailPage {
    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(css = "input#quantity")
    private WebElement quantityInput;

    @FindBy(css = "button.cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingButton;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    public void setQuantity(String quantity) {
        wait.waitForVisibility(quantityInput).clear();
        quantityInput.sendKeys(quantity);
    }

    public void clickAddToCart() {
        wait.waitForVisibility(addToCartButton).click();
    }

    public void clickContinueShopping() {
        wait.waitForVisibility(continueShoppingButton).click();
    }
}
