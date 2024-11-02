package pageobjectclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends basepage
{

	public loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement loginemail;
	@FindBy(xpath = "//input[@id='input-password']") WebElement loginpwd;
	@FindBy(xpath = "//input[@class='btn btn-primary']") WebElement logibutton;
	
	
	
	
	
	public void enterloginemail(String userid) 
	{
		loginemail.sendKeys(userid);
	}
	
	public void enterpwd(String pwd) 
	{
		loginpwd.sendKeys(pwd);
	}
	
	public void clickOnsubmit() 
	{
		logibutton.click();
	}
	
	
	

}
