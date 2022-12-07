package com.flipkartDatadriven;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testflipkart {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Selinum/chromedriver");

		WebDriver p = new ChromeDriver();
		p.manage().window().maximize();
		p.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.get("https://www.flipkart.com/");
		p.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(3000);
		WebElement iphone = p.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/child::div/child::input"));
		String allData = Flipkart.allData("Flipkart", 1, 0);
		iphone.sendKeys(allData);
	
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
		p.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
		Thread.sleep(5000);

		TakesScreenshot screenShot = (TakesScreenshot) p;
		File storage = screenShot.getScreenshotAs(OutputType.FILE);
		File path = new File("/Users/r.harish/eclipse-workspace/Flipkart/ScreenShot/Flipkartiphone.png");
		FileUtils.copyFile(storage, path);
		Thread.sleep(3000);
		p.quit();
	}
}
