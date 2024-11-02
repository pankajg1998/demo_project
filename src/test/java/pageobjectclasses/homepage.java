package pageobjectclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends basepage
{

	public homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath = "//li[@class=\"dropdown\"]//a[@title='My Account']") WebElement myaccounnt;
	@FindBy(linkText = "Register") WebElement registerlink;
	@FindBy(linkText = "Login") WebElement loginlink;
	
	
	public void ClickOnMyacc()
	{
		myaccounnt.click();
		
	}
	
	public void ClickOnRegister() 
	{
		registerlink.click();
		
	}
	
	public void ClickOnLogin() 
	{
		loginlink.click();
		
	}
	
	
	

}
