package com.BaseClassFlipkart;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class BaseClassFk {
	public static WebDriver p =null;
    public static void sendKeys(WebElement element, String values) {
	element.sendKeys(values);
}
	
	public static void click(WebElement element) {
        element.click();
	}
	public static void clear(WebElement element) {
		element.clear();
	}
	public static void selectvalue(WebElement element, String values) {
		Select P = new Select(element);
		P.selectByValue(values);
	}
	public static void selecttext(WebElement element, String values) {
		Select h = new Select(element);
		h.selectByVisibleText(values);
	}
	public static void selectindex(WebElement element, int values) {
		Select hp = new Select(element);
		hp.selectByIndex(values);
	}
	public static void currentUrl( String values) {
		p.get(values);
	}
	public static WebDriver browserLaunch(String value) {
		if(value.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Selinum/chromedriver");
			p = new ChromeDriver();
			p.manage().window().maximize();
			
		}else if(value.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "/Users/r.harish/eclipse-workspace/Selinum/edgedriver");
			p = new EdgeDriver();
			p.manage().window().maximize();
			
		}else if(value.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver", "/Users/r.harish/eclipse-workspace/Selinum/geckodriver");
			p = new FirefoxDriver();
			p.manage().window().maximize();
			
		}
		return p;
		
	}
	
	public static void close() {
		p.close();
	}
	public static void implictwait() {
		p.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public static void alert() {
		p.switchTo().alert().accept();
	}
//	public static String  text(WebElement element) {
//		return text(null);
//	}
	public static void navi() {
		p.navigate().back();
	}
	public static void maxi() {
		p.manage().window().maximize();
	}
	
	public static void screenShot(String FileName) throws IOException {
	TakesScreenshot screen = (TakesScreenshot)p;
	File source = screen.getScreenshotAs(OutputType.FILE);
	File destination = new File("/Users/r.harish/eclipse-workspace/Flipkart/ScreenShot/"+FileName+ ".png");
	FileUtils.copyFile(source, destination);
	
	
	
	
}
}
