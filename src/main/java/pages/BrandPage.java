package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class BrandPage {
    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(xpath = "//h2[contains(text(),'Brands')]")
    private WebElement brandHeader;

    @FindBy(xpath = "//a[contains(text(),'Polo')]")
    private WebElement poloBrand;

    public BrandPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    public void selectPoloBrand() {
        wait.waitForVisibility(poloBrand).click();
    }

    public boolean isBrandHeaderVisible() {
        return wait.waitForVisibility(brandHeader).isDisplayed();
    }
}
