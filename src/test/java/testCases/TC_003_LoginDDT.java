package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	/*Data is valid  - login success - test pass  - logout
	Data is valid -- login failed - test fail

	Data is invalid - login success - test fail  - logout
	Data is invalid -- login failed - test pass
	*/
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email,String password,String exp) {
		
		logger.info("***Starting TC_003_LoginDDT***");
		
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount...");
		hp.clickLogin();
		logger.info("Clicked on Login...");
		
		MyAccountPage myacc=new MyAccountPage(driver);
		logger.info("Validating MyAccount page exists...");
		boolean targetPage=myacc.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				myacc.clkLogout();
				logger.info("Clicked on Logout...");
				logger.info("Test Passed...");
				Assert.assertTrue(true);
			}
			else {
				logger.info("Test Failed...");
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				myacc.clkLogout();
				logger.info("Clicked on Logout...");
				logger.info("Test Failed...");
				Assert.assertTrue(false);
			}
			else {
				logger.info("Test Passed...");
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e) {
			Assert.fail("An exception occured: "+e.getMessage());
		}
		logger.info("***Finished TC_003_LoginDDT***");
	}

}
