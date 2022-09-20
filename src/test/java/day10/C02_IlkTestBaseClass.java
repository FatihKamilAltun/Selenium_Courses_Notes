package day10;

import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }
}
