package day28;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Practice3 {

	@Test
	public void test() throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(new File("./data/Selenium.xlsx"));

		for (int i = 0; i < 5; i++) {
			for(int j=0; j<3; j++) {
			String data = wb.getSheet("Sheet2").getRow(i).getCell(j).getStringCellValue();
			System.out.print(data + " ");
		}
			System.out.println();
	}
		wb.close();
	}

}
