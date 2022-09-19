package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    - "Click for JS Alert" butonuna tıklayalım
    - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
     */
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
        driver.close();
    }

    @Test
    public void method01() {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // - "Click for JS Alert" butonuna tıklayalım
        WebElement JSAlertButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        JSAlertButton.click();

        // - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
        driver.switchTo().alert().accept();


    }
}
