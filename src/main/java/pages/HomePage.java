package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class HomePage {
    private WebDriver driver;
    private WaitUtils wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginLink;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesLink;

    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    private WebElement deleteAccountLink;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInAsText;

    public void clickSignupLogin() {
        wait.waitForVisibility(signupLoginLink).click();
    }

    public void clickTestCases() {
        wait.waitForVisibility(testCasesLink).click();
    }

    public void clickProducts() {
        wait.waitForVisibility(productsLink).click();
    }

    public void clickContactUs() {
        wait.waitForVisibility(contactUsLink).click();
    }

    public void clickDeleteAccount() {
        wait.waitForVisibility(deleteAccountLink).click();
    }

    public boolean isLoggedInTextVisible(String expectedText) {
        return wait.waitForVisibility(loggedInAsText).getText().contains(expectedText);
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

}
