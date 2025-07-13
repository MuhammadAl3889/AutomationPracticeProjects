package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class RecommendedItemsPage {
    private WebDriver driver;
    private WaitUtils wait;

    public RecommendedItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    @FindBy(xpath = "//*[contains(text(),'recommended items')]")
    private WebElement recommendedItemsHeader;

    @FindBy(xpath = "(//div[@id='recommended-item-carousel']//a[contains(text(),'Add to cart')])[1]")
    private WebElement addToCartFirstRecommended;

    public boolean isRecommendedSectionVisible() {
        return wait.waitForVisibility(recommendedItemsHeader).isDisplayed();
    }

    public void addRecommendedProductToCart() {
        wait.waitForVisibility(addToCartFirstRecommended).click();
    }

    public void clickViewCart() {
        WebElement viewCart = wait.waitForVisibility(
                driver.findElement(By.xpath("//u[normalize-space()='View Cart']")));
        viewCart.click();
    }
}
