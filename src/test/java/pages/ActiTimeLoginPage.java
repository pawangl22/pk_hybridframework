package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ActiTimeLoginPage {

	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(name = "pwd")
	private WebElement pwdTB;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(xpath = "//span[contains(text(),'invalid')]")
	private WebElement errMsg;

	public ActiTimeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pwd) {
		pwdTB.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public boolean verifyErrMsgDisplayed(WebDriverWait wait) 
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Error Message is displayed", true);
			return true;
		} 
		catch (Exception e) {
			Reporter.log("Error Message is not displayed", true);
			return false;
		}
	}
}
