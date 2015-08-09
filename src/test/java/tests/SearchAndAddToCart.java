package tests;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static setup.SetupDriver.getDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchAndAddToCart {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver = getDriver();
        baseUrl = "http://luciana.integro.kiev.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("a")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("123@123.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.id("search_mini"));
        driver.findElement(By.id("search_mini")).clear();
        driver.findElement(By.id("search_mini")).sendKeys("TEST");
        driver.findElement(By.id("mini-search-submit")).click();
        driver.findElement(By.xpath(".//*[@id='content-shop']/ul/li[1]/div[1]/div[3]/div/a")).click();
        driver.findElement(By.xpath(".//*[@id='header-cart-search']/div[1]/div[3]/div/div/a")).click();
        driver.findElement(By.cssSelector("td.product-thumbnail > a > img.woocommerce-placeholder.wp-post-image")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //driver.manage().wait()(ExpectedConditions.elementToBeClickable(By.cssSelector(".cat-item")));
        List<WebElement> catalogElements = driver.findElements(By.cssSelector(".cat-item"));
        for (WebElement catalogElement : catalogElements) {
            System.out.println(catalogElement.getText());
        }
        assertEquals(38, catalogElements.size());
        assertNotNull(catalogElements);
    }

    @After
    public void tearDown() throws Exception {

        driver.quit();

        }
    }