package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // Yeni bir class olusturun: WindowHandle
        // Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();
        // Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        String techProWindowHandle = driver.getWindowHandle();

        // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "TECHPROEDUCATION";
        Assert.assertFalse(actualTitle2.contains(expectedTitle2));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
        String walmartWindowHandle = driver.getWindowHandle();

        // Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitle3=driver.getTitle();
        String expectedTitle3="Walmart";
        Assert.assertTrue(actualTitle3.contains(expectedTitle3));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));
    }
}
