package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        // Yeni bir class olusturalim: MouseActions2
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);

        // 1.Yol
        // actions.dragAndDrop(dragMe,dropHere).perform();

        // 2.Yol
        actions.clickAndHold(dragMe).
                moveToElement(dropHere).
                click().
                perform();


        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());
    }
}
