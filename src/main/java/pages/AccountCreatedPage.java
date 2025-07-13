package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class AccountCreatedPage {
    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(xpath = "//h2[contains(text(),'Account Created!')]")
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    public boolean isAccountCreatedVisible() {
        return wait.waitForVisibility(accountCreatedMessage).isDisplayed();
    }

    public void clickContinue() {
        wait.waitForVisibility(continueButton).click();
    }
}
