package com.jd.Dealerpath;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dealerpath_Login {
	ChromeDriver driver;
  @Test(priority=1)
  public void Login() throws InterruptedException {
	    driver.findElement(By.id("okta-signin-username")).sendKeys("n2a9t56");
		driver.findElement(By.id("okta-signin-password")).sendKeys("Laptop12345");
		driver.findElement(By.id("okta-signin-submit")).click();
		Thread.sleep(10000);
		//driver.findElement(By.className("app-title")).isDisplayed();
		driver.findElement(By.cssSelector("#main-header > div.header-body.size-wrap > div > h1")).isDisplayed();
		
		
	 
		
		
  }
  
  @Test(priority=3)
  public void Logout() throws InterruptedException {
	  
	 
		
		driver.findElement(By.cssSelector("#js-user-info > span.primary-caret.spr")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.cssSelector("#js-user-info-pop > div.popover-footer > button")).click();
		//to get the text and verify
		Thread.sleep(10000);
		String ActText=driver.findElement(By.xpath("//h2[normalize-space()='Sign In']")).getText();
		String ExpText="Sign In";
		Assert.assertEquals(ExpText, ActText);
		//to get the current URL and verify
		String ActURL=driver.getCurrentUrl();
		String ExpURL="https://sso-cert.johndeere.com/";
		Assert.assertEquals(ExpURL, ActURL);
		
  }
 
  @Test(priority=2)
  public void testMyPreferences () throws InterruptedException
  {
	  driver.findElement(By.cssSelector("#js-user-info > span.primary-caret.spr")).click();
	  Thread.sleep(2000);
	  driver.findElementById("preferences").click();
	  Thread.sleep(5000);
	  driver.findElementById("preference-cancel").click();
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https:\\dealerpathqualauth.tal.deere.com");
		Thread.sleep(10000);
  }

 /* @AfterTest
  public void afterTest() {
	  driver.quit();//close all the browser opened
  }*/

}
