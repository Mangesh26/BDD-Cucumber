package stepDefinition;

import init.util.DriverAction;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pageDefination.Home_Page;
import pageDefination.Login_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Steps extends DriverAction{

	 //Define Logs
	 static Logger logger = Logger.getLogger("Login_Steps.class");
	 
	 // Page object
	 Login_Page loginPageObj = new Login_Page();
	 Home_Page homePageObj = new Home_Page();
	 
	@cucumber.api.java.Before
	public void driverAcess() throws IOException {
		driver = InilizeDriver();
		driver.manage().window().maximize();
	}
	
	@Given(value = "^User launch the aplication$")
	public void launch() throws Exception {
		launchApp(driver);
	}
	
	@When("^page load$")
	public void pageLoad(){
		System.out.println("Page is loaded");
	}
	
	@When("^User enter Username(.*) and Password(.*)$")
	public void credentials(String username,String password) throws Exception{
		loginPageObj.loginName(driver, username);
		logger.info("test121....");
		loginPageObj.loginPassword(driver, password);
	}
	
	@When("^User click on submit button$")
	public void clkSubmit() throws Exception {
		loginPageObj.loginClickButton(driver);
	}
	
	@Then("^Application should navigate to home page$")
	public void navigate_hmePage() throws Exception{
		Assert.assertTrue(homePageObj.verifyImgHeader(driver));
	}
	
	@Then("^Application should not navigate to home page$")
	public void verify_lgnPage() throws Exception{
		Assert.assertFalse(homePageObj.verifyImgHeader(driver));
	}
	
	@Then("^should display image header$")
	public void verifyImgHeader() {
			System.out.println("Test");
			int a=3/0;
		/*}catch(Exception e){
			takeSnapShot(driver);
			//Assert.assertTrue(false);
		}*/
	}
	
	@Then("^should display error message$")
	public void verifyErrorMessage() throws Exception {
		Assert.assertTrue(loginPageObj.verifyErrMessage(driver));
	}
	
	@Then("^login button should be displayed$")
	public void verifyLoginbutton() throws Exception{
		Assert.assertTrue(loginPageObj.verifyLoginButton(driver));
	}
	
	@Then("^User able to verify facebook icon$")
	public void verifyfacebookIcon() throws Exception{
		try{
			System.out.println("Test");
			int a=3/0;
		}catch(Exception e){
			System.out.println("Error message : "+e);
			Assert.assertTrue(false);
		}
	}
	
	@cucumber.api.java.After
	public void driverKill() throws IOException {
		driver.close();
	}
	
}
