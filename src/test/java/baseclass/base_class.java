package baseclass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.opentelemetry.api.logs.Logger;
import jdk.internal.org.jline.utils.Log;

public class base_class
{
	public static WebDriver driver;
	public org.apache.logging.log4j.Logger logger;
	
	@Parameters({"browser","os"})
	@BeforeClass
	public void setup(String br, String os) throws IOException 
	{
		
		logger=LogManager.getLogger(this.getClass());
		
		logger.info("*****Opening browser");
		
		String huburl="http://192.168.29.185:4444/wd/hub";
		
		if (readpropertiesfile("execution_env").equalsIgnoreCase("remote"))
		{
			
			
			DesiredCapabilities cap=new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
				
			}
			else if(os.equalsIgnoreCase("mac")) 
			{
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os");
				return;
			}
			
			
			switch (br.toLowerCase()) 
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("edge");break;
			default:System.out.println("No matching browser");return;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.29.185:4444/wd/hub"),cap);
		}
		
		
		if (readpropertiesfile("execution_env").equals("local")) 
		{
			switch (br.toLowerCase()) 
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;

			default: System.out.println("invalid brower"); return;
			}
			
			
		}
		
		
		
		
		
		
		/*switch (br.toLowerCase()) 
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;

		default: System.out.println("invalid brower"); return;
		}*/
		
		driver.manage().deleteAllCookies();
		driver.get(readpropertiesfile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		
		
		logger.info("**** browser opened***");
	}
	
	@AfterClass
	public void teardown() 
	{
		driver.close();
		driver.quit();
	}
	
	public String randomString()
	{
		String randomstring=RandomStringUtils.randomAlphabetic(10);
		return randomstring;
		
	}
	
	public String randomnumber()
	{
		String randomnum=RandomStringUtils.randomNumeric(10);
		return randomnum;
	}
	
	public String radomalphanum() 
	{
		String alphanum=RandomStringUtils.randomAlphanumeric(5, 5);
		return alphanum;
	}
	
	public String readpropertiesfile(String key) throws IOException 
	{
		FileReader file=new FileReader("C:\\Workspace\\seleniumWebdriver\\demo_project\\src\\test\\resources\\config.properties");
		Properties prop=new Properties();
		prop.load(file);
		String values=prop.getProperty(key);
		return values;
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	

}
