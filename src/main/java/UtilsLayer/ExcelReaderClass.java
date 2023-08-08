package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReaderClass extends BaseClass{
	public static XSSFWorkbook workbook;
	public ExcelReaderClass(String path) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
	}
	public int getrow(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum() + 1;
		// coz row number starts from 0 index
	}
	public int getcolumn(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		// coz cell number starts from number 1 
	}
	public Object getACellValue(int sheetIndex, int row, int column) {
		
		XSSFCell cell = workbook.getSheetAt(sheetIndex).getRow(row).getCell(column);
		if (cell == null) {
			return "";
		}
		if (cell != null) {
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();
			}
			else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getRawValue();
			}
			else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cell.getCellFormula();
			}
		}
		return null;
	}
	public Object[][] getSheetValues(int sheetIndex){
		int rows = getrow(sheetIndex);
		int columns = getcolumn(sheetIndex);
		Object [][] data = new Object[rows][columns];
		for (int i = 0; i<rows ;i++) {
			for (int j =0; j<columns ; j++) {
				data[i][j] = getACellValue(sheetIndex, i, j);
			}
		}
		return data;
	}
}
