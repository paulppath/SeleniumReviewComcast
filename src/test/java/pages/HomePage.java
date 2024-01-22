package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInBtn;
    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement fistNameInputField;
    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement lastNameInputField;
    @FindBy(xpath = "//input[@id='EmailAddress']")
    public WebElement emailInputField;
    @FindBy(xpath = "//input[@id='ZipCode']")
    public WebElement zipCode;
    @FindBy(xpath = "//button[@class='button button-primary button-text']")
    public WebElement getStartBtn;
    @FindBy(xpath = "//h2[@class='headline-2']")
    public WebElement helpFullHeader;
    @FindBy(xpath = "//a[@id='bx-close-inside-2449058']")
    public WebElement promoBarCloseBtn;
}
