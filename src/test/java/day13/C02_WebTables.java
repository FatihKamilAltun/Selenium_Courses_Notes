package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // Bir class oluşturun : C02_WebTables
        // login( ) metodun oluşturun ve oturum açın.
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        // Username : manager
        // Password : Manager1!

    }


    private void table() {
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.

        /*

         */


        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : " + sutunSayisi.size());
        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        // 4.satirdaki(row) elementleri konsolda yazdırın.
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        // driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}
