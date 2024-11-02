package utilities;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class Dataproviders 
{
	@DataProvider(name = "LoginData")
	public String[][] getdata() throws IOException  
	{
		String path="C:\\Workspace\\seleniumWebdriver\\demo_project\\Test Data\\Logintestdata.xlsx";
		
		excelutility xluti=new excelutility(path);
		
		int totalrows=xluti.getrowcount("Sheet1");
		int totalcells=xluti.getcellcount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcells];
		
		for (int i = 1; i <= totalrows; i++) 
		{
			for (int j = 0; j < totalcells; j++) 
			{
				logindata[i-1][j]=xluti.getcelldata("Sheet1", i, j);
				
			}
			
		
			
		}
		
		return logindata;
				
		
	}

}

