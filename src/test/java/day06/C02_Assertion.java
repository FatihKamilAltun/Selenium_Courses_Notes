package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
    Amazon sayfasina gidelim
    3 farkli test methodu olusturalim
        a- URL'nin 'amazon' icerdigini test edelim
        b- Title'in 'facebook' icermedigini test edelim
        c- Sol üst kosede 'amazon' logosunun gorundugunu test edelim
     */

    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void method01() {
        // a- URL'nin 'https://www.facebook.com' icerdigini test edelim
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.facebook.com";
        Assert.assertNotEquals("Mesaj",actualURL,expectedURL);

    }

    @Test
    public void method02() {
        // b- Title'in 'facebook' icermedigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }

    @Test
    public void method03() {
        // c- Sol üst kosede 'amazon' logosunun gorundugunu test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());


    }








    @After
    public void tearDown() {
        driver.close();
    }

}
