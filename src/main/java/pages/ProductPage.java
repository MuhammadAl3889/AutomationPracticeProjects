package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class ProductPage {

    private WebDriver driver;
    private WaitUtils wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }


    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement productsSection;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement firstViewProduct;

    @FindBy(xpath = "//div[@class='product-information']")
    private WebElement productInformationBox;

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    private WebElement searchedProductsHeader;

    @FindBy(xpath = "//a[@data-product-id='1']")
    private WebElement firstAddToCartButton;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    private WebElement viewCartLink;

    public boolean areProductsVisible() {
        return wait.waitForVisibility(productsSection).isDisplayed();
    }

    public void clickViewProduct() {
        wait.waitForVisibility(firstViewProduct).click();
    }

    public boolean isProductDetailVisible() {
        return wait.waitForVisibility(productInformationBox).isDisplayed();
    }

    public void searchForProduct(String productName) {
        wait.waitForVisibility(searchInput).sendKeys(productName);
        wait.waitForVisibility(searchButton).click();
    }

    public boolean isSearchedProductVisible() {
        return wait.waitForVisibility(searchedProductsHeader).isDisplayed();
    }

    public void clickAddToCart() {
        wait.waitForVisibility(firstAddToCartButton).click();
    }

    public void clickViewCart() {
        wait.waitForVisibility(viewCartLink).click();
    }
}
