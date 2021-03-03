package com.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Headless_Browser {
	ChromeDriver driver;
  @Test(priority=1)
  public void Login() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed(); 
	 
		
		
  }
  
  @Test(priority=2)
  public void Logout() throws InterruptedException {
	  
	 
		
		driver.findElement(By.id("welcome")).click();
		//Thread.sleep(10000);
		//----------------ExplicitWait Example--------------
				WebDriverWait wait = new WebDriverWait(driver, 60);
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
				String ActText=element.getText();
				System.out.println(ActText);
				element.click();
		
		//driver.findElement(By.linkText("Logout")).click();
		/*to get the text and verify
		String ActText=driver.findElement(By.id("loginPanelHeading")).getText();
		String ExpText="LOGIN Panel";
		Assert.assertEquals(ExpText, ActText);
		//to get the current URL and verify
		String ActURL=driver.getCurrentUrl();
		String ExpURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		Assert.assertEquals(ExpURL, ActURL);
		//To verify the title
		String ActTitle=driver.getCurrentUrl();
		String ExpTitle="OrangeHRM";
		Assert.assertEquals(ExpTitle, ActTitle);*/
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  
	  ChromeOptions options=new ChromeOptions();
	  options.setHeadless(true);
	  options.addArguments("incognito");
	  
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();//close all the browser opened
  }

}
