package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {


    @Test
    public void test01(){
        // - amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // - account menusunden 'create a list' linkine tıklayalım
        WebElement accountList=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir.
        Aksi takdirde html kodları arasında web elementi bulur ama ulaşamadığı için
        'ElementNotInteractableExpection' element not interactable excpetion'i firlatir
         */
        WebElement createAList= driver.findElement(By.xpath("//*[text()='Create a List']"));
        createAList.click();

    }
}
