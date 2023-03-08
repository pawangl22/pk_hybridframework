package day28;

import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Practice2 {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path = "./data/Selenium.xlsx";
		Workbook wb = WorkbookFactory.create(new File(path));
		Sheet s1 = wb.getSheet("Sheet1");
		Row r1 = s1.getRow(0);
		Cell c1 = r1.getCell(0);
		String data = c1.getStringCellValue();
		Reporter.log(data, true);
		wb.close();
	}

}
