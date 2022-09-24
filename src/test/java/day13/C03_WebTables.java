package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();

        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        int satir=3;
        int sutun=4;
        Thread.sleep(5000);
        WebElement cell= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satir ve sutundaki text : " + cell.getText());

        //PhoneNo başlığındaki tum numaraları yazdırınız
        List<WebElement> phoneBasligi=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement each:phoneBasligi
             ) {
            System.out.println(each.getText());
        }


    }

    private void login() {
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
