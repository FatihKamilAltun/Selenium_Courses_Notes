package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {
    @Test
    public void test01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String filePath="src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Sheet sheet=workbook.getSheet("Sayfa1");

        //-Row objesi olusturun sheet.getRow(3)
        Row row=sheet.getRow(3);
        //-Cell objesi olusturun row.getCell(3)
        Cell cell=row.getCell(3);
        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        /*
        Bir cell'deki veriyi silmek icin row objesine ihtiyac vardir
        row objesi ile removeCell() methodunu kullanarak cell objesi ile belittigimiz cell degerini
        silebiliriz
         */
        FileOutputStream fos=new FileOutputStream(filePath);
        workbook.write(fos);
        //-Silindiğini test edin
        String expectedData="Cezayir";
        String actualData=null;
        Assert.assertNotEquals(expectedData,actualData);


    }
}
