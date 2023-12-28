package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * This class is generic class designed to read data from external resource file 
 *
 */
public class FileLibrary {
	 public String propertyFile(String key) throws IOException {
		 FileInputStream fis=new FileInputStream("./TestData/commondata.property");
		 Properties p= new Properties();
		 p.load(fis);
		 String url = p.getProperty(key);
		 return url;
	 }
	 /**
	  * 
	  * @param sheet
	  * @param row
	  * @param cell
	  * @return
	  * @throws IOException
	  */
	 public String excelFile(String sheet, int row,int cell) throws IOException {
		 FileInputStream fis1=new FileInputStream("./TestData/Testdata.xlsx");
		    Workbook wb = WorkbookFactory.create(fis1);
		    String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		    return data;
	 }
}
