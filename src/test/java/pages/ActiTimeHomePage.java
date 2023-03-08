package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiTimeHomePage {
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public ActiTimeHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogoutLink(WebDriverWait wait) {
		
		try {
				wait.until(ExpectedConditions.visibilityOf(logoutLink));
				Reporter.log("ActiTime Home page is displayed", true);
				return true;
		}
		catch (Exception e) {
			
			Reporter.log("ActiTime Home page not is displayed", true);
			return false;
		}
		
	}

}
