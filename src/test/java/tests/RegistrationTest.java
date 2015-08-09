package tests;

import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.junit.Assert.fail;
import static setup.SetupDriver.getDriver;

public class RegistrationTest {
    public static final String Error = "Error: An account is already registered with your email address. Please login.";
    public static final String ERROR_MSG = Error;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // System.setProperty("webdriver.chrome.driver", "D:\\Work\\chromedriver.exe");
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void Register() throws Exception {


        MainPage page = PageFactory.initElements(driver, MainPage.class);
        page.register("123@123.com", "123456");

        WebElement errorElement = driver.findElement(By.cssSelector("ul.woocommerce-error > li"));
        assertEquals(ERROR_MSG, errorElement.getText());
        System.out.println("Test has Passed");
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}