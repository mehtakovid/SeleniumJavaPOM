package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataReader {

	static Workbook book;
	static Sheet sheet;
		
		public static Object[][] readExcelData(String FilePath, String SheetName) throws EncryptedDocumentException, IOException {
			
			FileInputStream file = new FileInputStream(FilePath);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(SheetName);
			DataFormatter formatter = new DataFormatter();
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum();i++) {
				for(int k=0;k<sheet.getRow(0).getLastCellNum(); k++) {
					
					data[i][k] = formatter.formatCellValue(sheet.getRow(i+1).getCell(k));
				}
			}
			return data;
			
		}
		
		

	
}
