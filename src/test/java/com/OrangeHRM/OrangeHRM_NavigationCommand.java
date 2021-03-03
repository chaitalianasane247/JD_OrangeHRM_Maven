package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class OrangeHRM_NavigationCommand {
	ChromeDriver driver;
	 @Test(priority=1)
	  public void Login() throws InterruptedException {
		    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed(); 
			WebElement admin =driver.findElementById("menu_admin_viewAdminModule");
			Actions action = new Actions(driver);
			action.moveToElement(admin).build().perform();
			WebElement usermanagement=driver.findElementByLinkText("User Management");
			action.moveToElement(usermanagement).build().perform();
			Thread.sleep(5000);;
			driver.findElementByLinkText("Users").click();
			driver.navigate().back();
			Thread.sleep(3000);
			String dashboardURL=driver.getCurrentUrl();
			System.out.println(dashboardURL);
			driver.navigate().forward();
			Thread.sleep(3000);
			String userUrl=driver.getCurrentUrl();
			System.out.println(userUrl);
			
		 
			
			
	  }
	  
	  
	  
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
