package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlari kullaniyorsak olusturacagimiz method'u static yapmamiz gerekiyor
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void method01() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }

    @Test
    @Ignore("calismayacak benim testim degil")
    /*
    Calismasini istemedigimiz testler icin @Ignore notasyonu kullaniriz
     */
    public void method02() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://haberserbest.com");
    }

    @Test
    public void method03() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }
}
