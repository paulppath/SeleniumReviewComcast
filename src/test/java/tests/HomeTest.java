package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import data.pojo.QuoterInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class HomeTest extends BaseTest
{
    HomePage page;
    @BeforeMethod
    public void setUp()
    {
        page = new HomePage(driver);
    }
    @Test(testName = "US001 Sign in Btn", description = "Verify sign in btn is displayed")
    public void test01()
    {
//        String text = page.signInBtn.getText();
        String text = page.getText(page.signInBtn);
        Assert.assertTrue(page.signInBtn.isDisplayed());
    }

    // Test US002 was created to practice a lot of things such as report, POJO
    @Test(testName="US002 Get quote", description = "Verify after fill in info and click btn")
    public void test02_1()
    {
        QuoterInfo quoter = new QuoterInfo();
        System.out.println(quoter.toString());

        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='FirstName']")));
        Actions actions = new Actions(driver);

        page.scrollIntoView(driver.findElement(By.xpath("//a[@class=' button button--lg button-primary']")), driver);
        page.scrollIntoView(driver.findElement(By.xpath("//a[@class='button button-primary']")), driver);
        page.scrollIntoView(driver.findElement(By.xpath("//a[@class='btn67876']")), driver);
        page.scrollIntoView(driver.findElement(By.xpath("//a[@title='READ MORE']")), driver);

        page.isDisplayed(page.fistNameInputField);
        page.fistNameInputField.sendKeys(quoter.getFirstName());
        page.lastNameInputField.sendKeys(quoter.getLastName());
        page.emailInputField.sendKeys(quoter.getEmail());
        page.zipCode.sendKeys(quoter.getZipCode());

        page.getStartBtn.click();

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("exampleReport.html");

        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Paul's Report");
        spark.config().setReportName("Get Quote Report");
        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("get quote");

        test.pass("Test Pass");
        test.info("Test info");
        test.skip("Test skipped");
        test.fail("Test Failed");
        test.warning("Warning example");

        test.pass(MarkupHelper.createLabel("Pass with highlight", ExtentColor.AMBER));

        extent.flush();

    }
    @Test (testName = "US0021 Get quote (improve)", description = "Improve version of Get quote test")
    public void test02_2()
    {
        page.click(page.promoBarCloseBtn);
        QuoterInfo quoterInfo = new QuoterInfo();
        page.scrollIntoView(page.helpFullHeader,driver);
        page.sendKeys(page.fistNameInputField, quoterInfo.getFirstName());
        page.sendKeys(page.lastNameInputField, quoterInfo.getLastName());
        page.sendKeys(page.emailInputField, quoterInfo.getEmail());
        page.sendKeys(page.zipCode, quoterInfo.getZipCode());
    }
    @Test(testName = "US003 Text displayed", description = "Helpful resources text is displayed")
    public void test03()
    {
//        page.scrollIntoView(page.helpFullHeader,driver);
        page.isDisplayed(page.helpFullHeader);
    }
}
