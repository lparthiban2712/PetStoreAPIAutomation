package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {
	
	@DataProvider(name="allusertestdata")
	public String[][] getalluserdata() throws IOException
	{
		
		String testdatafilepath=System.getProperty("user.dir")+"//testdata//apitestdata.xlsx";
		
		XLutilities xl=new XLutilities(testdatafilepath);
		
		int rowcount=xl.getrowcount("Sheet1");
		int columncount=xl.getcolumncount("Sheet1");
		String[][]testdata=new String[rowcount][columncount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				testdata[i-1][j]=xl.getcelldata("Sheet1", i, j);
			}
		}
		
		return testdata;
	}
	
	@DataProvider(name="allusernames")
	public String[] getallusernames() throws IOException
	{
		
		String testdatafilepath=System.getProperty("user.dir")+"//testdata//apitestdata.xlsx";
		
		XLutilities xl=new XLutilities(testdatafilepath);
		
		int rowcount=xl.getrowcount("Sheet1");
		
		String[]username=new String[rowcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			
			username[i-1]=xl.getcelldata("Sheet1", i,1);
			}
		
		
		return username;
	}

}
