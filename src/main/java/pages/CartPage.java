package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.WaitUtils;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> cartRows;

    @FindBy(xpath = "//input[@class='cart_quantity_input']")
    private WebElement quantityInput;

    @FindBy(xpath = "//button[contains(text(),'Proceed To Checkout')]")
    private WebElement proceedToCheckoutButton;

    public boolean isCartNotEmpty() {
        return !cartRows.isEmpty();
    }

    public void updateQuantity(int quantity) {
        wait.waitForVisibility(quantityInput).clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public String getQuantity() {
        return wait.waitForVisibility(quantityInput).getAttribute("value");
    }

    public void clickProceedToCheckout() {
        wait.waitForVisibility(proceedToCheckoutButton).click();
    }

    // ✅ New Method to Validate Recommended Product
    public boolean isRecommendedProductVisible() {
        try {
            WebElement recommendedProductRow = driver.findElement(By.xpath("//tbody/tr[td[contains(text(),'Blue Top')]]"));
            return recommendedProductRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
