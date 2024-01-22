package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseTest
{
    SignInPage page;
    @BeforeMethod
    public void setUp() {
        page = new SignInPage(driver);
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
    }
    @Test(testName = "US101", description = "Validate text is display when log in with wrong email",
    dataProvider = "email", dataProviderClass = data.DataProviders.class)
    public void test101(String email)
    {

//        Faker faker = new Faker();
//        String email = faker.internet().emailAddress();
        System.out.println("Email = " + email);

//        driver.get("https://business.comcast.com/");
//        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id='sign_in']")).click();

        String expected = "Incorrect email address or password. Please try again.";
        try{
            String actual = driver.findElement(By.xpath("//p[text()='Incorrect email address or password. Please try again.']")).getText();
            Thread.sleep(2000);
            System.out.println("Actual : " + actual);
            Assert.assertEquals(actual, expected);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
