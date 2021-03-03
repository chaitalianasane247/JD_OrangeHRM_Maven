package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover_OrangeHRM {
	ChromeDriver driver;
	  @Test(priority=1)
	  public void Login() throws InterruptedException {
		    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			
			
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			
			WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

	        Actions action = new Actions(driver);
	        
	        action.moveToElement(admin).build().perform();
	        WebElement usermanagement = driver.findElementByLinkText("User Management");
	        action.moveToElement(usermanagement).build().perform();
	        Thread.sleep(5000);
	        driver.findElementByLinkText("Users").click();
		 
			
			
	  }
	  
	  /*@Test(priority=2)
	  public void Logout() throws InterruptedException {
		  
		 
			
			driver.findElement(By.id("welcome")).click();
			Thread.sleep(10000);
			
			driver.findElement(By.linkText("Logout")).click();
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
			Assert.assertEquals(ExpTitle, ActTitle);
	  }*/
	  
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			Thread.sleep(20000);
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();//close all the browser opened
	  }
}
