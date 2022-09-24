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
        // ● Bir class oluşturun : C02_WebTables
        // ● login( ) metodun oluşturun ve oturum açın.
        girisYap();

        // ● table( ) metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi : " + sutunBasliklari.size());

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        // Tum body'i bir string olarak yazdirmak isterseniz body elementini locate ederk getText() ile yazdırılabilir
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // ● printRows( ) metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirlarListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirlarListesi
        ) {
            System.out.println(each.getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each : cellList
        ) {
            System.out.println(each.getText());
        }

        // Email basligindaki tum elementleri(sutun) konsolda yazdırın
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size() ; i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunListesi=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:emailSutunListesi) {
            System.out.println(each.getText());
        }
    }

    private void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        WebElement loginBox = driver.findElement(By.xpath("//input[@class='form-control required']"));
        actions.click(loginBox).
                sendKeys("manager" + Keys.TAB).
                sendKeys("Manager1!").
                perform();
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
    }


}
