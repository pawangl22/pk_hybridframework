package day28;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Practice5 {
	
	@Test
	public void test() throws EncryptedDocumentException, IOException {
	Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Selenium.xlsx"));
	String un = wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
	String pw = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.id("username")).sendKeys(un);
	driver.findElement(By.name("pwd")).sendKeys(pw);
	driver.findElement(By.id("loginButton")).click();
	

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleContains("Enter"));
	String title = driver.getTitle();
	System.out.println(title);
	driver.quit();
	
	wb.getSheet("login").getRow(1).createCell(2).setCellValue(title);
	wb.write(new FileOutputStream("./data/Selenium.xlsx"));
	wb.close();
	}

}
