package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String filePath="src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int actualLastRow=workbook.getSheet("Sayfa2").getLastRowNum();          // Kullanılan son satiri dondurur
        int expectedLastRow=15;
        Assert.assertEquals(expectedLastRow,actualLastRow+1);

        int kullanilanRow=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();  // Toplamda kullanilan satir sayisini dondurur
        System.out.println(kullanilanRow);
        int expectedKullanilanRow=5;
        Assert.assertEquals(expectedKullanilanRow,kullanilanRow);
    }
}
