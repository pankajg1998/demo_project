package pageobjectclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class myprofile extends basepage
{

	public myprofile(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "(//div[@id='account-account']//h2)[1]") WebElement myacccount;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutlink;
	@FindBy(linkText = "Continue") WebElement confirmlogout;
	
	
	
	public boolean isloggedinsuccessfully() 
	{
		try
		{
		return (myacccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickonlogout() 
	{
		Actions act=new Actions(driver);
		act.moveToElement(logoutlink).build().perform();
		logoutlink.click();
		
		
	}
	
	public void clickonconfirmlogout()
	{
		confirmlogout.click();
	}

}
