package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;
import utilities.ConfigReader;

public class TestCasesPage {
    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(xpath = "//h2[contains(text(),'Test Cases')]")
    private WebElement testCasesHeader;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    public boolean isTestCasesContentVisible() {
        return wait.waitForVisibility(testCasesHeader).isDisplayed();
    }
}
