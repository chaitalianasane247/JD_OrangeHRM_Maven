package com.OrangeHRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Logout {
	ChromeDriver driver;
	
	@Before
	public void launchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(100000);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@After
	public void closeBrowser()
	{
		driver.quit();//close all the browser opened
	}

	@Test
	public void loginSuccessfulScenario() throws InterruptedException {
		
		//Launch the chrome browser
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		
		
		
		
		//driver.close();//close the current browser
	}

}
