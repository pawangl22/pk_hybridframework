package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ActiTimeHomePage;
import pages.ActiTimeLoginPage;

public class ActiTimeloginTest extends BaseTest {

		@Test(priority=1, groups= {"smoke"})
		public void VerifyActiTimeLogin() {
		//Login UN Enter
		ActiTimeLoginPage actiTimeLogin = new ActiTimeLoginPage(driver);
		actiTimeLogin.setUserName("admin");
		//Login Pw Enter
		actiTimeLogin.setPassword("manager");
		//Click loginBTN
		actiTimeLogin.clickLoginButton();
		
		//Verify LogoutButton is present or not
		ActiTimeHomePage actiTimeHome = new ActiTimeHomePage(driver);
		boolean result = actiTimeHome.verifyLogoutLink(wait);
		
		//True or false
		Assert.assertEquals(result, true);
	}
}
