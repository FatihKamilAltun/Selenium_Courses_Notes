package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_MavenIlkTest {
    /*
   1- https://www.amazon.com/ sayfasina gidelim
   2- arama kutusunu locate edelim
   3- “Samsung headphones” ile arama yapalim
   4- Bulunan sonuc sayisini yazdiralim
   5- Ilk urunu tiklayalim
   6- Sayfadaki tum basliklari yazdiralim
    */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        // 2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // 3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones" + Keys.ENTER);

        // 4- Bulunan sonuc sayisini yazdiralim
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] resultArr=resultText.getText().split(" ");
        System.out.println("Arama sonucunda " + resultArr[2] + " tane sonuç bulundu");

                // lambda ile
                Arrays.stream(resultArr).limit(3).skip(2).forEach(t-> System.out.println("aramada " + t+ " adet sonuc bulundu"));

        // 5- Ilk urune tiklayalim
        driver.findElement(By.xpath("(//img[@data-image-latency='s-product-image'])[1]")).click();


        // 6- Sayfadaki tum basliklari yazdirin
        System.out.println(driver.findElement(By.xpath("//h1")).getText());

        // 7- Sayfayi kapatiniz
        driver.close();
    }
}
