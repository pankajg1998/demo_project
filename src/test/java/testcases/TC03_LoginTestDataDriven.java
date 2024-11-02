package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.base_class;
import pageobjectclasses.homepage;
import pageobjectclasses.loginpage;
import pageobjectclasses.myprofile;
import utilities.Dataproviders;

public class TC03_LoginTestDataDriven extends base_class
{
	@Test(dataProvider = "LoginData" , dataProviderClass = Dataproviders.class)
	public void verifyloginDDf(String email, String pass, String exp) throws InterruptedException 
	{
		
		logger.info("**** Data driver login starting");
		
		
		try {
			
			System.out.println(email+"  " + pass+ "   "+ exp);
			homepage hp=new homepage(driver);
			hp.ClickOnMyacc();
			hp.ClickOnLogin();
			
			
			loginpage lp=new loginpage(driver);
			lp.enterloginemail(email);
			lp.enterpwd(pass);
			lp.clickOnsubmit();
			
			
			myprofile mp=new myprofile(driver);
			boolean checklogin=mp.isloggedinsuccessfully();
			
			System.out.println(checklogin);
			
			
	
			if (exp.equalsIgnoreCase("valid")) 			
			{
			     if (checklogin==true) 
			    {
					
					mp.clickonlogout();
					mp.clickonconfirmlogout();
					Assert.assertTrue(true);
				}
				
				else {
					Assert.assertTrue(false);
				}
			}
			
			
			
		if (exp.equalsIgnoreCase("invalid")) 
			{
				if (checklogin==true) 
				{
					
					mp.clickonlogout();
					mp.clickonconfirmlogout();
					Assert.assertTrue(false);
					
				}
				else 
				{
					Assert.assertTrue(true);
					
				}
				
			}
		
		
		logger.info("*****Data driven loginn test completed");
			
		
		
			
		} catch (Exception e) 
		{
			Assert.fail();
		}
		
		
	}}
	


