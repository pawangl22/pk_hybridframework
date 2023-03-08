package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.ActiTimeHomePage;
import pages.ActiTimeLoginPage;

public class ValidActiTimeLogin extends BaseTest {

		@Test(priority=1)
		public void testValidLogin() {
			
		String un = Excel.getData("./data/input.xlsx", "VerifyActiTimeLogin", 1, 0);
		String pw = Excel.getData("./data/input.xlsx", "VerifyActiTimeLogin", 1, 1);
		
		//Login UN Enter
		ActiTimeLoginPage actiTimeLogin = new ActiTimeLoginPage(driver);
		actiTimeLogin.setUserName(un);
		//Login Pw Enter
		actiTimeLogin.setPassword(pw);
		//Click loginBTN
		actiTimeLogin.clickLoginButton();
		
		//Verify LogoutButton is present or not
		ActiTimeHomePage actiTimeHome = new ActiTimeHomePage(driver);
		boolean result = actiTimeHome.verifyLogoutLink(wait);
		
		//True or false
		Assert.assertEquals(result, true);
	}
}
