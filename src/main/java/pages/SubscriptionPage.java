package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class SubscriptionPage {
    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(id = "subscribe_email")
    private WebElement emailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
    private WebElement successMessage;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    public void subscribeWithEmail(String email) {
        wait.waitForVisibility(emailInput).sendKeys(email);
        subscribeButton.click();
    }

    public boolean isSubscriptionSuccessful() {
        return wait.waitForVisibility(successMessage).isDisplayed();
    }
}
