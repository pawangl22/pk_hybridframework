package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getData(String path, String sheet, int row, int column) {

		String data="";
		try {
				Workbook wb = WorkbookFactory.create(new FileInputStream(path));
				data = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
			} 
		catch (Exception e) {
			
		}
		return data;
	}

}
