package day12;

import org.apache.hc.core5.http.nio.support.AbstractAsyncPushHandler;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SynchronizationWait extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // Bir class olusturun : WaitTest
        // Iki tane metod olusturun : implicitWait() , explicitWait()
        // Iki metod icin de asagidaki adimlari test edin.
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
    }

    @Test
    public void test02() {
        // Bir class olusturun : WaitTest
        // Iki tane metod olusturun : implicitWait() , explicitWait()
        // Iki metod icin de asagidaki adimlari test edin.
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

         /*
         explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
         sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
         mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */


        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());

    }
}
