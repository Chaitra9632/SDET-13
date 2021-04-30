package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods for reading the data in excel sheet
 * @author Nitheesha
 *
 */
public class ExcelUtility {
	/**
	 *This method used to read data from excel by specifing sheetname, row number and cell number 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return cell string value
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		return cell.getStringCellValue();
	}
	/**
	 * This method return all the data in the sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
