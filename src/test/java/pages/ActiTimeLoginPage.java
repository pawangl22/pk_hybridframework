package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeLoginPage {
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwdTB;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
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

}
