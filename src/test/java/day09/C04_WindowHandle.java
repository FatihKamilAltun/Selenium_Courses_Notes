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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {


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
        //driver.quit();
    }

    @Test
    public void test01(){
       // Tests package’inda yeni bir class olusturun: WindowHandle2
       // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

       // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertTrue(text.isDisplayed());

       // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

       // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList=new ArrayList<>(driver.getWindowHandles()); // window handle değerleri
        driver.switchTo().window(windowList.get(1));

        /*
        Bir websitesine gittiğimizde bir webelementine tıkladığımızda yeni bir sekme ya da pencere açılırsa
        bu yeni açılan sekmenin veya pencerenin handle değerini buulabilmek için driver.getwindowhandles() methodunu
        bir ArrayList'e atıp bütün sayfaların listesine ulaşabiliriz
        İlk açtığım pencerenin index'i 0'dır.
        İkinci açılan sekmenin index'i 1'dir. Ve ikinci açılan pencerede ya da sekmede işlem yapabilmek için
        driver.switchTo().window(listadi.get(index)) methodunu kullanabiliriz
         */

                                                                                                    /*
                                                                                                    Set<String> windowHandleseti= driver.getWindowHandles();
                                                                                                    System.out.println(windowHandleseti);
                                                                                                    String ikinciSayfaWindowHandleDegeri="";
                                                                                                    for (String each: windowHandleseti) {
                                                                                                        if (!each.equals(ilkSayfaWindowHandleDegeri)){
                                                                                                            ikinciSayfaWindowHandleDegeri=each;
                                                                                                        }
                                                                                                    }
                                                                                                     */


       // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("New Window"));

       // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

       // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}
