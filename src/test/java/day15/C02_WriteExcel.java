package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {
        // Yeni bir Class olusturalim WriteExcel
        // Yeni bir test method olusturalim writeExcelTest()
        // Adimlari takip ederek 1.satira kadar gidelim
        // 5.hucreye yeni bir cell olusturalim
        // Olusturdugumuz hucreye “Nufus” yazdiralim
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);

        // 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nüfus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");

        // 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");
        // 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("540.000");
        // Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(filePath);
        workbook.write(fos);

        // 10)Dosyayi kapatalim
        fis.close();
        fos.close();



    }
}
