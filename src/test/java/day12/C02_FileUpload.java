package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileUpload extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // Tests packagenin altina bir class oluşturun : C05_UploadFile
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonuna basalim
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));

        // Yuklemek istediginiz dosyayi secelim.
        String filePath="C:\\Users\\FatihKamil\\Downloads\\Test.txt";
        chooseFile.sendKeys(filePath);

        // Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());

    }
}
