package day08;

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

public class C02_Allerts {
    /*
    Bir web sitesine girdiğimizde bir uyarı mesajı ya da bir butona tıkladığımızda
    bir uyarı(alert) çıkabilir.
    Eğer bu uyarıyı incele(inspect) yapabiliyorsak bu tür alert'lere HTML alert denir ve istediğimiz locate'i alabiliriz.
    Ancak gelen uyarısına müdahale(incele,inspect) edemiyorsak bu tür alert'lere de JavaScript Alert denir.
    JavaScript alert'lere müdahale edbilmek için
    - tamam ya da ok için   --> driver.switchTo().alert().accept() kullanılır
    - iptal için            --> driver.switchTo().alert().dismiss() kullanılır
    - alert içindeki mesaji almak için --> driver.switchTo().alert().getText() kullanılır
    - alert bizden metin girmemizi istiyorsa --> driver.switchTo().alert().senKeys("") kullanılır
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void test01() {
        //  Bir metod olusturun: acceptAlert
        //  1. butona tıklayın,
        WebElement JSAlertButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        JSAlertButton.click();

        // Alert üzerindeki mesaji yazdıralım
        System.out.println("1. butonun alert mesaji : " + driver.switchTo().alert().getText());

        // Uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.switchTo().alert().accept();
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualResultText, expectedText);


    }

    @Test
    public void test02() {
        //  Bir metod olusturun: dismissAlert
        //  2. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // Alert üzerindeki mesaji yazdıralım
        System.out.println("2. butonun alert mesaji : " + driver.switchTo().alert().getText());

        // Uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // “successfuly” icermedigini test edin.
        driver.switchTo().alert().dismiss();
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText="successfuly";
        Assert.assertFalse(actualResultText.contains(expectedText));


    }

    @Test
    public void test03() {
        //  Bir metod olusturun: sendKeysAlert
        //  3. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Alert üzerindeki mesaji yazdıralım
        System.out.println("3. butonun alert mesaji : " + driver.switchTo().alert().getText());

        //  Uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().sendKeys("Fatih Kamil");
        driver.switchTo().alert().accept();
        String actualResultText=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText="Fatih Kamil";
        Assert.assertTrue(actualResultText.contains(expectedText));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
