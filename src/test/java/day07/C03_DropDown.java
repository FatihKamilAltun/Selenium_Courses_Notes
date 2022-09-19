package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() {
         driver.close();
    }

                        /*
                        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
                        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
                        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
                        butun elemanlarının sayısına ulasabiliriz
                        */

    @Test
    public void method01() {
        // -Test1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        // oldugunu testedin
        WebElement ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi = 45;
        int actualDds = ddmList.size();
        Assert.assertNotEquals(expectedSayi, actualDds);

    }

    @Test
    public void method02() {
        // -Test2
        WebElement ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select = new Select(ddm);

        // 1.Kategori menusunden Books seceneginisecin
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 3.Bulunan sonuc sayisiniyazdirin
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] resultArr = result.getText().split(" ");
        System.out.println(resultArr[3] + " adet sonuc bulundu");

        // 4.Sonucun Java kelimesini icerdigini testedin
        String actualResultText = result.getText();
        String expectedResultText="Java";
        Assert.assertTrue(actualResultText.contains(expectedResultText));

        /*
        Dropdown menüde seçtiğimiz optiona ulaşmak istersek select.getFirstSelectedOption()
        methodunu kullanırız
         */


    }
}
