package com.Runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.BaseClassFlipkart.BaseClassFk;
import com.flipkart.property.ConfigurationHelper;
import com.sdp.Sdp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="/Users/r.harish/eclipse-workspace/Flipkart/src/test/java/com/feature/Flipkart.feature" ,
glue="com.FlipkartStepDefintion",monochrome = true,
plugin= {"pretty",
		"html:Report/htmlReport.html",
		"json:Report/jsonreport.json",
		"junit:Report/junitReport.xml"}
		//"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"
)

public class FlipkartRunner extends BaseClassFk{
	
 public	static WebDriver p=null;
 
	@BeforeClass
	public static void setUp() throws IOException {
//	System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Selinum/chromedriver");
//	 p = new ChromeDriver();
		String browser = ConfigurationHelper.getInstance().getBrowser();
		p=browserLaunch(browser);
		//Sdp flipkart = new Sdp(p);
	}
	
	@AfterClass
	public static void tearDown() {
     //p.close();
     
     close();
	}

}
