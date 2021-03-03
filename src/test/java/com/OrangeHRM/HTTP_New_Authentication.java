package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTTP_New_Authentication {
	WebDriver driver;
	  @Test
	  public void HTTPAuth() throws InterruptedException {
		  driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		  Thread.sleep(15000);
		  driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		  Thread.sleep(5000);
		  String confmsg=driver.findElement(By.xpath("//*[@id='content']/div/p")).getText();
		  System.out.println(confmsg);
		
	  }
	  @BeforeTest
	  public void LaunchBrowser() {
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
	  }

	  @AfterTest
	  public void CloseBrowser() {
			driver.quit();
	  }
}
