package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_KeyUpKeyDown extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // Bir Class olusturalim KeyboardActions1
        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();

        // Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox)
                .sendKeys("s")
                .sendKeys("a")
                .sendKeys("m")
                .sendKeys("s")
                .sendKeys("u")
                .sendKeys("n")
                .sendKeys("g")
                .sendKeys(" ")
                .keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT)
                .sendKeys("7")
                .sendKeys("1").sendKeys(Keys.ENTER).perform();

        // aramanin gerceklestigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")));

    }
}
