package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.Homepage;
import com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {
	FileLibrary f=new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite 
	public void connectToDataBase(){
		Reporter.log("Database is connected",true);
	}
	@BeforeClass
	public void LaunchBrowser() throws IOException{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.propertyFile("URL");
		driver.get(url);
		Reporter.log("Browser is launched",true);	
	}
	@BeforeMethod
	public void login() throws IOException {
		String un = f.propertyFile("UN");
		String pw = f.propertyFile("PW");
	    LoginPage lp=new LoginPage(driver);
	    lp.getUntbx().sendKeys(un);
	    lp.getPwtbx().sendKeys(pw);
	    lp.getLgbtn().click();
	Reporter.log("Logged in Successfully",true);
	}
	@AfterMethod
	public void logOut() {
		Homepage hp= new Homepage(driver);
		hp.getLgbtn().click();
		Reporter.log("Logged out Successfully",true);
	}
	@AfterClass
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Closed Browser Successfully",true);
	}
	@AfterSuite
	public void DatabaseDisconnect() {
		Reporter.log("Database disconnected Successfully",true);
	}
}
