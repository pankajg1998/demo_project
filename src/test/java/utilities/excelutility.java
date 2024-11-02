package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutility 
{
	//public FileInputStream file;
	FileInputStream file;
	XSSFWorkbook worksbook;
	XSSFSheet   sheet;
	XSSFRow row;
	XSSFCell cell;
	
	String path;

	public excelutility(String path) 
	{
		this.path=path;
	}
	
	public int getrowcount(String sheetname) throws IOException 
	{
		file=new FileInputStream(path);
		worksbook=new XSSFWorkbook(file);
		sheet=worksbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		worksbook.close();
		file.close();
		return rowcount;
		
	}
	
	public int getcellcount(String sheetname, int rownum ) throws IOException 
	{
		file=new FileInputStream(path);
		worksbook=new XSSFWorkbook(file);
		sheet=worksbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		worksbook.close();
		file.close();
		return cellcount;
		
	}
	
	public String getcelldata(String sheetname, int rownum , int cellnum) throws IOException 
	{
		file=new FileInputStream(path);
		worksbook=new XSSFWorkbook(file);
		sheet=worksbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		 cell=row.getCell(cellnum);
		 
		 DataFormatter formatter=new DataFormatter();
		 String data;
		 try
		 {
			 data=formatter.formatCellValue(cell);
			}
		 catch (Exception e)
		 {
			 data="";
			}
		worksbook.close();
		file.close();
		return data;
		
	}
}
