package day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test01 (){
        driver.get("https://amazon.com");
        driver.navigate().refresh();
    }
}
