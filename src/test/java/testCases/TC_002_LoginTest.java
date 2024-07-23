package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verifyLogin() {
		
		logger.info("***Starting TC_002_LoginTest***");
		logger.info("capturing application debug logs");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount..");
		hp.clickLogin();
		logger.info("Clicked on Login..");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid username and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clkSubmit();
		logger.info("Clicked on Login button..");
		
		MyAccountPage myacc=new MyAccountPage(driver);
		logger.info("Verifying myAccount..");
		boolean targetPage=myacc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		finally {
			logger.info("***Finished  TC_002_LoginTest***");
		}
		
	}
	

}
