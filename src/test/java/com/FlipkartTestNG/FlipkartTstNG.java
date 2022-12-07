package com.FlipkartTestNG;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.BaseClassFlipkart.BaseClassFk;
import com.flipkartDatadriven.Flipkart;

public class FlipkartTstNG extends BaseClassFk{
	public WebDriver p = null;
@Test(priority = 0)
	public void browserLaunch() {
//		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Selinum/chromedriver");
//		p = new ChromeDriver();
p=browserLaunch("chrome");
		//p.manage().window().maximize();

	}
@Test(dependsOnMethods = "browserLaunch")
	public void getUrl() {
		//p.get("https://www.flipkart.com/");
	currentUrl("https://www.flipkart.com/");
	}
@Test(priority = 1, timeOut = 5000)
	public void searchProduct() throws InterruptedException {
		WebElement search = p.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		//.click();
		click();		
		Thread.sleep(3000);
	}
@Test(dependsOnMethods = "searchProduct")
	public void searchButton() throws IOException {
		WebElement iphone = p.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/child::div/child::input"));
		String allData = Flipkart.allData("Flipkart", 1, 0);
		//iphone.sendKeys(allData);
		sendKeys(iphone, allData);
	}
@Test(priority = 2, timeOut = 10000)
	public void Text() throws InterruptedException {
		p.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/child::button")).click();
		List<WebElement> text = p.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (WebElement singleText : text) {
			Thread.sleep(4000);
			System.out.println(singleText.getText());

			if (singleText.equals("APPLE iPhone 14 Pro (Space Black, 512 GB)")) {
				System.out.println("Equals");

			} else {
				System.out.println("Not Equals");
				break;
			}

		}
		System.out.println("Total count" + "=" + text.size());
		Thread.sleep(4000);
	}
@Test(dependsOnMethods = "Text",timeOut = 6000)
	public void click() throws InterruptedException {
		WebElement click = p.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		//.click();
		click();
		Thread.sleep(5000);
	}
@Test(priority = 3)
	public void takeScreenshot() throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) p;
		File storage = screenShot.getScreenshotAs(OutputType.FILE);
		File path = new File("/Users/r.harish/eclipse-workspace/Flipkart/ScreenShot/Flipkartiphone.png");
		FileUtils.copyFile(storage, path);
	
	}

}
