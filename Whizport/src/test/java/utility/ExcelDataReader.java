package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;


import jxl.Sheet;
import jxl.Workbook;
import jxl.common.Logger;
import jxl.read.biff.BiffException;

public class ExcelDataReader {

	final static Logger logger = Logger.getLogger(ExcelDataReader.class);


	private static XSSFSheet ExcelWSheet;
	//private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	//private static XSSFRow Row;
	private static String excelFile;

	public ExcelDataReader(String excelFilePath) {
		excelFile = excelFilePath;
	}


/**
 * This method is used to get Excel data
 * @param sheetName
 * @return
 */
	public String[][] getExcelData(String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(excelFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int row = 1; row < totalNoOfRows; row++) {
				for (int col = 0; col < totalNoOfCols; col++) {
					arrayExcelData[row - 1][col] = sh.getCell(col, row).getContents();
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("Error: Excel file is not found: ", e);
		} catch (BiffException e) {
			logger.error("Error: BiffException occured: ", e);
		} catch (IOException e) {
			logger.error("Error: IOException occured: ", e);
		}
		return arrayExcelData;
	}


/**
 * This method is used to get cell data from a table.
 * @param RowNum
 * @param ColNum
 * @return
 */
	public static String getCellData(int RowNum, int ColNum) {
		String cellData = null;
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			cellData = Cell.getStringCellValue();
		} catch (Exception e) {
			logger.error("Error: exception occured: ", e);
		}
		return cellData;
	}

}
