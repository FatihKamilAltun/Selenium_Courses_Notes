package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        // “create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        // “firstName” giris kutusuna bir isim yazin
        // “surname” giris kutusuna bir soyisim yazin
        // “email” giris kutusuna bir email yazin
        // “email” onay kutusuna emaili tekrar yazin
        // Bir sifre girin
        // Tarih icin gun secin
        // Tarih icin ay secin
        // Tarih icin yil secin
        // Cinsiyeti secin
        // Kaydol butonuna basın
        // Sayfayi kapatin
        WebElement nameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        String email=faker.internet().emailAddress();
        actions.click(nameBox).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("25").sendKeys(Keys.TAB).
                sendKeys("Eyl").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

                /*
                Faker class'ını kullanma amacımız form doldurmamız gereken web sitelerinde defalarca kendi üreteceğimiz veriler yerine
                bizim için random veriler üretir ve işimizi kolaylaştırır.

                Faker class'ını kullanmak için mvnrespository.com adresinden java faker kütüphanesini aratır ve en çok kullanılanı
                pom.xml dosyamıza (dependencies tagları arasına) ekleriz. Sonra faker class'ından bir obje oluşturup;

                email için: faker.internet() methodunu kullanarak emailAddress() method'unu seçeriz.
                password: faker.internet().password()
                isim: faker.name().firstName()
                soyisim: faker.name().lastName()

                method'larını kullanırız.
                */


    }
}
