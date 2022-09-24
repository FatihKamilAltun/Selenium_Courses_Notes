package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData= workbook.
                getSheet("Sayfa1").
                getRow(3).
                getCell(3).
                toString();
        System.out.println(actualData);
    }
}
