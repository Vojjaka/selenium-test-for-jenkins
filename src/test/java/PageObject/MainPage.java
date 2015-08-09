package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static setup.SetupDriver.getDriver;

public class MainPage {

    public static final String Luciana = "http://luciana.integro.kiev.ua/";
    private WebDriver driver;

    @FindBy(css = "a")
    WebElement a;

    @FindBy(id = "reg_email")
    WebElement register;

    @FindBy (id = "reg_password")
    WebElement passwordField;

    @FindBy (xpath = "(.//*[@class='button'])[3]")
    WebElement login;



    public void register(String username, String password){
        driver = getDriver();
        driver.get(Luciana);
        a.click();
        register.clear();
        register.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        login.click();
    }

    /*
    driver.findElement(By.cssSelector("a")).click();

        WebElement email = driver.findElement(By.id("reg_email"));
        WebElement passwordField = driver.findElement(By.id("reg_password"));

        clearSendKeys(email, passwordField);

        driver.findElement(By.name("register")).click();

        WebElement errorElement = driver.findElement(By.cssSelector("ul.woocommerce-error > li"));
*/

}
