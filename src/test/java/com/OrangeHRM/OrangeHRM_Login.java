package com.OrangeHRM;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {

	@Test
	public void loginSuccessfulScenario() throws InterruptedException {
		WebDriver driver;
		
		//Launch the chrome browser
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(100000);*/
		 //Create proxy class object
		  Proxy p=new Proxy();
		  // Set HTTP Port to 8080
		  p.setHttpProxy("localhost:8080");
		  // Create desired Capability object
		  DesiredCapabilities cap=new DesiredCapabilities();
		  // Pass proxy object p
		  cap.setCapability(CapabilityType.PROXY, p);
			WebDriverManager.chromedriver().setup();
		  //WebDriverManager.iedriver().setup();
		  //driver = new InternetExplorerDriver(cap);
			driver = new ChromeDriver(cap);
			driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.quit();//close all the browser opened
		
		
		
		//driver.close();//close the current browser
	}

}
