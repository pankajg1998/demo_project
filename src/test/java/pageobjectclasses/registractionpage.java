package pageobjectclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registractionpage extends basepage
{

	public registractionpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	@FindBy (xpath ="//input[@id='input-firstname']") WebElement fn;
	@FindBy (xpath = "//input[@id='input-lastname']") WebElement ln;
	@FindBy (xpath = "//input[@id='input-email']") WebElement email;
	@FindBy (xpath = "//input[@id='input-telephone']") WebElement telephone;
	@FindBy (xpath = "//input[@id='input-password']") WebElement password;
	@FindBy (xpath = "//input[@id='input-confirm']") WebElement confirmpassword;
	@FindBy (xpath = "//input[@name='agree']") WebElement agree;
	@FindBy (xpath = "//input[@class='btn btn-primary']") WebElement cont;
	@FindBy (xpath = "//div[@id='content']/h1") WebElement successfulmsg;
	
	
	public void enterfn(String firstname) 
	{
		fn.sendKeys(firstname);
	}
	
	public void enterln(String lastname) 
	{
		ln.sendKeys(lastname);
	}
	
	public void enteremail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void entertelephone(String tele) 
	{
		telephone.sendKeys(tele);
		
	}
	
	public void enterpassword(String pwd) 
	{
		password.sendKeys(pwd);
	}
	
	public void enterconfirmpass(String confirmpass) 
	{
		confirmpassword.sendKeys(confirmpass);
	}
	
	public void agreement()
	{
		agree.click();
	}
	
	public void continueButton()
	{
		cont.click();
	}
	
	
	public String confirm() 
	{
		String confmsg=successfulmsg.getText();
		return confmsg;
		
	}
	
	
	
	
	
	

}
