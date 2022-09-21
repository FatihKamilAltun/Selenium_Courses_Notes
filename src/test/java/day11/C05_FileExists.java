package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {
    @Test
    public void downloadTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/download adresine gidin
        driver.get("https://the-internet.herokuapp.com/download");

        // 'test.txt' dosyasını indirin
        driver.findElement(By.xpath("//*[text()='Test.txt']")).click();
        Thread.sleep(2500);

        // Ardından dosyanın başarıyla indirilip indirilmediğini test edin
        String anaDizin = System.getProperty("user.home");
        String dosyaYolu="\\Downloads\\Test.txt";
        String filePath=anaDizin+dosyaYolu;
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        // İndirildiğini konsolda gosterin
        System.out.println(Files.exists(Paths.get(filePath)));

    }
}
