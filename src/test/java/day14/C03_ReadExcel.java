package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {



        // Belirtilen satırNo ve sutunNo degerlerini parametre olarak alıp o cell'deki datayı konsola yazdiralim
        int satir=12, sutun=2;

        String filePath="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
        String data=workbook.
                getSheet("Sayfa1").
                getRow(satir-1).
                getCell(sutun-1).
                toString();
                // Index 0'dan basladigi icin bizden istenen satira ulasabilmek icin bir eksigini aliriz
        System.out.println(data);



        // Sonucun konsolda yazan ile aynı olduğunu dogrulayalim
        Assert.assertEquals("Baku",data);


    }
}
