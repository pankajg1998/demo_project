package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.base_class;
import pageobjectclasses.homepage;
import pageobjectclasses.loginpage;
import pageobjectclasses.myprofile;

public class TC02_LoginTest extends base_class
{
	@Test
	public void verifyLoginfunction() 
	{
		logger.info("******Login Test Started");
		try {
			homepage hp=new homepage(driver);
			hp.ClickOnMyacc();
			hp.ClickOnLogin();
			
			
			loginpage lp=new loginpage(driver);
			lp.enterloginemail("impankaj@gmail.com");
			lp.enterpwd("Automation@1234");
			lp.clickOnsubmit();
			
			myprofile mp=new myprofile(driver);
			boolean checklogin=mp.isloggedinsuccessfully();
			
			
			Assert.assertEquals(checklogin, true);
			
			
			mp.clickonlogout();
			mp.clickonconfirmlogout();
			
		} 
		catch (Exception e) 
		{
			Assert.fail();
			System.out.println("Login failed please check credentials");
			logger.info("*******Login Failed");
		
		}
		
		logger.info("*******Login Test Finished");
		
		
	}

}
