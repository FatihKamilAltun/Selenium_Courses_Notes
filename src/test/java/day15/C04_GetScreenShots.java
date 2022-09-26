package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShots extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //'https://amazon.com"' sayfasina gidip tum sayfanin ekran resmini alalim
        driver.get("https://amazon.com");
        /*
        Bir web sayfanin ekran resmini alabilmek için TakesScreenshots classindan obje olusturup
        File classindan gecici bir degiskene TakesScreenshots'tan olusturdugum objeden
        getScreenshotsAs(OutputType.FILE) methodunu kullanarak gecici bir file olustururuz.
         */
        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaResmi = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/screenshots/allPage "+date+".jpeg"));


    }
}
