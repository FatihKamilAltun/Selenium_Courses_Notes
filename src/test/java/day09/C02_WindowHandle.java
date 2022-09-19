package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

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
        //driver.close();
    }

    @Test
    public void test01() {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl = driver.getCurrentUrl();
        String searchedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(searchedUrl));

        String amazonWindowHandle = driver.getWindowHandle();

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bestbuy.com");

        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        String bestBuyWindowHandle = driver.getWindowHandle();

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement resultTextWE = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String resultText = resultTextWE.getText();
        Assert.assertTrue(resultText.contains("java"));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        //9- Sayfaları Kapatalım
        driver.quit();
    }
}
