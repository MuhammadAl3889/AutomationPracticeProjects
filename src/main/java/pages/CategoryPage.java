package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class CategoryPage {
    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    private WebElement categoryHeader;

    @FindBy(xpath = "//a[contains(text(),'Women')]")
    private WebElement womenCategory;

    @FindBy(xpath = "//a[contains(text(),'Dress')]")
    private WebElement womenDressSubcategory;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    public void expandWomenCategory() {
        wait.waitForVisibility(womenCategory).click();
    }

    public void clickDressSubcategory() {
        wait.waitForVisibility(womenDressSubcategory).click();
    }

    public boolean isCategoryHeaderVisible() {
        return wait.waitForVisibility(categoryHeader).isDisplayed();
    }
}
