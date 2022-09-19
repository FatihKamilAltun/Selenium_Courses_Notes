package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method01() {
        // 1 kez before methodu calisir
        driver.get("https://amazon.com");
        // 1 kez after methodu calisir
    }

    @Test
    public void method02() {
        // 1 kez before methodu calisir
        driver.get("https://hepsiburada.com");
        // 1 kez after methodu calisir
    }


    @After
    public void tearDown() {
        driver.close();
    }


}
