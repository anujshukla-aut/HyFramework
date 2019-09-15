package com.learnAutomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
 XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src = new File("C:\\Users\\Pankaj\\Desktop\\javaprojct\\TestData_excel\\Data_HybridFramework.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		}  catch (Exception e) {
		System.out.println("Unable to read excel file"+e);
		}
		}
	//method overloading used here
	public String getstringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	public String getstringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public double getnumeriData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
	}


}
