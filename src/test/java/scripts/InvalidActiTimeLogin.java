package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.ActiTimeLoginPage;

public class InvalidActiTimeLogin extends BaseTest{
	
	@Test(priority=2)
	public void testInvalidLogin() {
		
	String un = Excel.getData("./data/input.xlsx", "VerifyActiTimeLogin", 2, 0);
	String pw = Excel.getData("./data/input.xlsx", "VerifyActiTimeLogin", 2, 1);
	//Enter invalid userName
	ActiTimeLoginPage actiTimeLogin = new ActiTimeLoginPage(driver);
	actiTimeLogin.setUserName(un);
	
	//Enter invalid pwd
	actiTimeLogin.setPassword(pw);
	
	//Click on Login button
	actiTimeLogin.clickLoginButton();
		
	//Verify Error msg
	boolean result = actiTimeLogin.verifyErrMsgDisplayed(wait);
	Assert.assertEquals(result, true);
	}
}
