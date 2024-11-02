package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.base_class;
import pageobjectclasses.basepage;
import pageobjectclasses.homepage;
import pageobjectclasses.registractionpage;

public class TC01_RegisterUser extends base_class
{
	
	
	@Test
	private void registerusertest() {
	
		logger.info("TC01_Registration test started");
		try {
			homepage home=new homepage(driver);
			home.ClickOnMyacc();
			home.ClickOnRegister();
			
			registractionpage register=new registractionpage(driver);
			register.enterfn(randomString());
			register.enterln(randomString());
			register.enteremail(randomString()+"@gmail.com");
			register.entertelephone(randomnumber());
			register.enterpassword("98df@jjfje");
			register.enterconfirmpass("98df@jjfje");
			register.agreement();
			register.continueButton();
			
			String confmsg=register.confirm();
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
		} catch (Exception e) {
			Assert.fail();
			logger.info("Registration test failed");
		}
		
		
		
		logger.info("TC02_Registration test finished");
		
		
	
		

	}
	

}
