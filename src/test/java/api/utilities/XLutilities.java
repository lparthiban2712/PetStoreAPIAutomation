package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutilities {
	
	String filepath;
	
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public XLutilities(String filepath)
	{
		this.filepath=filepath;
	}
	
	
	public int getrowcount(String sheetname) throws IOException
	{
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		System.out.println("Row count is "+rowcount);
		return rowcount;
		
		
	}
	
	public int getcolumncount(String sheetname) throws IOException
	{
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(1);
		int columncount=row.getLastCellNum();
		System.out.println("Columns count is "+columncount);
		workbook.close();
		fis.close();
		return columncount;
		
		
	}
	
	public String getcelldata(String sheetname,int rownumber,int cellnnumber) throws IOException
	{
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownumber);
		cell=row.getCell(cellnnumber);
		DataFormatter dataformatter=new DataFormatter();
		
		String data=dataformatter.formatCellValue(cell);
		return data;
		
		
	}

}
