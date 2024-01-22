package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.ConfigReader;
import util.ExtentManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest
{

//    String path = ConfigReader.readProperty("configuration.properties", "path");
//    String path = "/Users/paulppath/Desktop/Selenium/libs/drivers/chromedriver";
    WebDriver driver;
    protected static ExtentManager reportManager;
    @BeforeSuite(alwaysRun = true)
    public void startReporter()
    {
        reportManager = new ExtentManager();
        reportManager.createReport();
    }

    @BeforeMethod(alwaysRun = true)
    public void baseSetUp(Method method)
    {
        WebDriverManager.chromedriver().setup(); // The WebDriverManager dependency that work as
//        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(ConfigReader.readProperty("configuration.properties","url"));

        reportManager.createTestReport(driver, method);
    }

    @AfterMethod(alwaysRun = true)
    public void baseTearDown(ITestResult result)
    {
        reportManager.closeTestReport(result);
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void closeReporter()
    {
        reportManager.closeReporter();
    }
}
