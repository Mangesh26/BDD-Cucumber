package init.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.listener.Reporter;

public class DriverAction extends BrowserAction{
	
	public static WebDriver driver =null;
	String url = null;

	/** The base_path. */
	private static String base_path = System.getProperty("user.dir");
	
	//Define The Properties
	 Properties prop = new Properties();
	
	 Logger logger = Logger.getLogger("DriverAction.class");
	
	
	public void launchApp(WebDriver driver) throws Exception
	{
		try{
			InputStream inputStream = new FileInputStream(base_path+"\\Config\\Config.properties");
			prop.load(inputStream);
			url=prop.getProperty("URL_app");
			driver.get(url);
			driver.manage().window().maximize();
			logger.info("Launching the application with URL : "+url);
		}catch(Exception ex){
			takeSnapShot(driver);
			logger.error("Exception during launching the app <{}> "+ex);
			throw new Exception();
		}
	}
	
	public  WebDriver InilizeDriver() throws IOException{
		try{
			
			try{
				InputStream inputStream = new FileInputStream(base_path+"\\Config\\Config.properties");
				prop.load(inputStream);
			}catch(FileNotFoundException ex){
				logger.error("Proerty File is not found <{}> "+ex);
			}
			
			logger.info("---------------------------------------START THE SCENARIO-------------------------------------------------------------------");
			logger.info("Driver is inilizing");
			
			//Get browser from Property file
			String browserType = prop.getProperty("Browser");
			if(browserType.equals("Firfox")){
					driver = new FirefoxDriver();
					return driver;
			}
			else if(browserType.equals("Chrome")){
					System.setProperty("webdriver.chrome.driver", base_path+"\\drivers\\chromedriver.exe");
					
					// Create object of ChromeOptions class
					ChromeOptions options = new ChromeOptions();
					 
					// add parameter which will disable the extension
					//options.addArguments("--disable-extensions");
					
					driver = new ChromeDriver(options);
					return driver;
			}
			else if(browserType.equals("InternetExplorer")){
					System.setProperty("webdriver.ie.driver", base_path+"\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					return driver;
			}
		}catch(Exception ex){
			logger.error("Exception during inilizing the driver <{}> "+ex);
		}
		
		return driver;
	}
	
	public static WebDriver getDriver()
    {
		return driver;
    }
	
	public void releaseDriver(WebDriver driver) {
		try{
			driver.quit();
		}catch(Exception ex){
			logger.error("Exception during disposing the driver : "+ex);
		}
		
	}

}
