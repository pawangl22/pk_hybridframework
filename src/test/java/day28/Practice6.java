package day28;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Practice6 {

	@Test
	public void test() throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(new File("./data/Selenium.xlsx"));
		int rc = wb.getSheet("Sheet2").getLastRowNum();

		for (int i = 0; i <= rc; i++) {
			try {
				int cc = wb.getSheet("Sheet2").getRow(i).getLastCellNum();
				for (int j = 0; j < cc; j++) {
					try {
						String data = wb.getSheet("Sheet2").getRow(i).getCell(j).getStringCellValue();
						System.out.print(data + " ");
					} catch (NullPointerException e) {
						System.out.print("-- ");
					}
				}
			} catch (NullPointerException e) {
				System.out.print("-- -- --");
			}
			System.out.println();
			wb.close();

		}

	}
}
