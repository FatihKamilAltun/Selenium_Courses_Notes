package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {


    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // Şu an içinde bulunduğum yolu gosterir

        System.out.println(System.getProperty("user.home"));
        // Geçerli kullanıcının ana dizinini verir


        String anaDizin=System.getProperty("user.home");
        String dosyaYolu="\\Desktop\\KAMİL\\MASAUSTU\\text.txt";
        String filePath=anaDizin+dosyaYolu;

        System.out.println(filePath);

        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
