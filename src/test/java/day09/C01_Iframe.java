package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {

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
    public void test01() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // ● Bir metod olusturun: iframeTest
        //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement textBoxWE = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(textBoxWE.isDisplayed());
        System.out.println(textBoxWE.getText());

        //    ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(1500);
        driver.findElement(By.xpath("//body[@class='mce-content-body ']")).clear();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//body[@class='mce-content-body ']")).sendKeys("Merhaba Dunya!");

        //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //      dogrulayin ve konsolda yazdirin

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumTextWE = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumTextWE.isDisplayed());
        System.out.println(elementalSeleniumTextWE.getText());

    }
}
