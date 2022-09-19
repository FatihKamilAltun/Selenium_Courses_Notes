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

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void method01() {

        // ●https://www.amazon.com/ adresinegidin.
        driver.get("https://www.amazon.com/");

        // -Test1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        // oldugunu testedin
        List<WebElement> dropDownMenu = driver.findElements(By.xpath("//option"));
        System.out.println(dropDownMenu.size());
        Assert.assertNotEquals(45,dropDownMenu);


    }
    @Test
    public void method02() {
        // -Test2
        driver.get("https://www.amazon.com/");

        // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        ddm.sendKeys("Books");

        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        // 3.Bulunan sonuc sayisiniyazdirin
        WebElement result=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] resultArr=result.getText().split(" ");
        System.out.println("Cikan sonuc sayisi : " +resultArr[3]);

        // 4.Sonucun Java kelimesini icerdigini testedin
        String actualResultText=result.getText();
        String expectedResultText="Java";
        Assert.assertTrue(actualResultText.contains(expectedResultText));
    }
}
