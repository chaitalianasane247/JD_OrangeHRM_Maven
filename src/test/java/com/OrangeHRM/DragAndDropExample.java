package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DragAndDropExample {
	ChromeDriver driver;
  @Test
  public void DragDrop() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		// Add 5 seconds wait
		Thread.sleep(3000);
		// Create object of actions class
		Actions act=new Actions(driver);
		// find element which we need to drag
		//WebElement drag=driver.findElementById("draggable");
		WebElement drag=driver.findElement(By.id("draggable"));

		// find element which we need to drop
		//WebElement drop=driver.findElementById("droppable");
		WebElement drop=driver.findElement(By.id("droppable"));
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		 Thread.sleep(5000);
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
