package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit {

    @Test
    public void method01(){
        WebDriverManager.chromedriver().setup();
        WebDriver drive =new ChromeDriver();
        drive.manage().window().maximize();
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        drive.get("https://amazon.com");
    }

    @Test
    public void method02(){
        WebDriverManager.chromedriver().setup();
        WebDriver drive =new ChromeDriver();
        drive.manage().window().maximize();
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        drive.get("https://facebook.com");
    }

    @Test
    public void method03(){
        WebDriverManager.chromedriver().setup();
        WebDriver drive =new ChromeDriver();
        drive.manage().window().maximize();
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        drive.get("https://hepsiburada.com");
    }


}
