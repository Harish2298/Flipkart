package com.FlipkartStepDefintion;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClassFlipkart.BaseClassFk;
import com.Runner.FlipkartRunner;
import com.flipkart.property.ConfigurationHelper;
import com.flipkartDatadriven.Flipkart;
import com.sdp.Sdp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartStepDef extends BaseClassFk{
	
	public static WebDriver p=FlipkartRunner.p;
	Sdp flipkart = new Sdp(p);
	@Given("^user Launch The Application$")
	public void user_Launch_The_Application() throws Throwable {
//		p.manage().window().maximize();
//		p.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		p.get("https://www.flipkart.com/");
		//currentUrl("https://www.flipkart.com/");
		String url = ConfigurationHelper.getInstance().getUrl();
		currentUrl(url);
	}

	@When("^user Select The Drop Down$")
	public void user_Select_The_Drop_Down() throws Throwable {
		
//		WebElement button = p.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
//		//click();
//		click(button);
		click(flipkart.getSearch().getButton());
		
	}

	@When("^user Enter Product In Searchbox$")
	public void user_Enter_Product_In_Searchbox() throws Throwable {
		Thread.sleep(3000);
//		WebElement iphone = p.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/child::div/child::input"));
//		String allData = Flipkart.allData("Flipkart", 1, 0);
//		//iphone.sendKeys(allData);
//		sendKeys(iphone, allData);
		//sendKeys(flipkart.getSearch().getIphone(),"iphone 14");
		String sheet = ConfigurationHelper.getInstance().getSheet();
		String allData = Flipkart.allData(sheet, 1, 0);
		sendKeys(flipkart.getSearch().getIphone(),allData);
	}

	@Then("^user Click The Search Option$")
	public void user_Click_The_Search_Option() throws Throwable {
//		WebElement search = p.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/child::button"));
//		//click();
//		click(search);
		click(flipkart.getSearch().getSearch());
	}
	@Then("^user Get Text Of All The Searched Products$")
	public void user_Get_Text_Of_All_The_Searched_Products() throws Throwable {
		//List<WebElement> text = p.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		//for (WebElement singleText : text) {
		for (WebElement singleText :flipkart.getResult().getText()) {
			Thread.sleep(4000);
			System.out.println(singleText.getText());

			if (singleText.equals("APPLE iPhone 14 Pro (Space Black, 512 GB)")) {
				System.out.println("Equals");
				
			} else {
				System.out.println("Not Equals");
				break;
			}
			
		}
		//System.out.println("Total count" + "=" + text.size());
		System.out.println("Total count" + "=" + flipkart.getResult().getText().size());
		Thread.sleep(4000);
	
	}

	@Then("^user Check The Condition TO Click the Required Option$")
	public void user_Check_The_Condition_TO_Click_the_Required_Option() throws Throwable {
//		WebElement click = p.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
//		//click();
//		click(click);
		click(flipkart.getResult().getClick());
		Thread.sleep(5000);
	}

	@Then("^user Get The Screenshot Of The Current Page$")
	public void user_Get_The_Screenshot_Of_The_Current_Page() throws Throwable {
//		TakesScreenshot screenShot = (TakesScreenshot) p;
//		File storage = screenShot.getScreenshotAs(OutputType.FILE);
//		File path = new File("/Users/r.harish/eclipse-workspace/Flipkart/ScreenShot/Flipkartiphone.png");
//		FileUtils.copyFile(storage, path);
//		Thread.sleep(3000); 
		screenShot("flipkart");
	}
}
