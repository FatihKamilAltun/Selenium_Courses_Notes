package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // - Dosya yolunu bir String degiskene atayalim
        String filePath = "src/resources/ulkeler.xlsx";

        // - FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath); //Oluşturmuş olduğumuz dosyayı sistemde işleme alır

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // - WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // Workbook objesiyle fis objesi ile akışa aldığımız dosyamızla bir excel dosyası create ettik

        // - Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // Excel'de dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz.

        // - Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa1'deki 3.satiri bu şekilde seçeriz

        // - Cell objesi olusturun row.getCell(index)
        Cell cell =row.getCell(3);
        System.out.println(cell);

        // - 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
    }
}
