package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_ extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        //  Yeni bir class olusturalim: MouseActions1
        //  https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstWindowHandle = driver.getWindowHandle();

        //  3- Cizili alan uzerinde sag click yapalim
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(box).perform();
        actions.contextClick().perform();


        //  Alert’te cikan yazinin “You selected a context menu” oldugunu
        //  test edelim.
        Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"));

        //  Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //  Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        /*
        List<String> newTabArr = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabArr.get(1));
        */

        Set<String> set = driver.getWindowHandles();
        String nextWindowHandle = "";
        for (String each : set
        ) {
            if (!each.equals(firstWindowHandle)){
                nextWindowHandle=each;
            }
        }
        driver.switchTo().window(nextWindowHandle);


        WebElement newTabText = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(newTabText.getText().contains("Elemental Selenium"));



    }
}
