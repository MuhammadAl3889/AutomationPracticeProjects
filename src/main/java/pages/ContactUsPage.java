package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class ContactUsPage {

    private WebDriver driver;
    private WaitUtils wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver, Integer.parseInt(ConfigReader.get("explicitWait")));
    }

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "subject")
    private WebElement subjectField;

    @FindBy(name = "message")
    private WebElement messageField;

    @FindBy(name = "upload_file")
    private WebElement uploadFileInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homeButton;

    // ===== Actions =====

    public void fillContactForm(String name, String email, String subject, String message) {
        wait.waitForVisibility(nameField).sendKeys(name);
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        wait.waitForVisibility(uploadFileInput).sendKeys(filePath);
    }

    public void clickSubmit() {
        wait.waitForVisibility(submitButton).click();
    }

    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            // Handle no alert
            System.out.println("No alert found.");
        }
    }

    public String getSuccessMessage() {
        return wait.waitForVisibility(successMessage).getText();
    }

    public void clickHomeButton() {
        wait.waitForVisibility(homeButton).click();
    }
}
