package com.sdp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Result {
	public WebDriver p;
	
	@FindBy(xpath ="//div[@class='_4rR01T']" )
	private List<WebElement>  text ;

	@FindBy(xpath ="(//div[@class='_4rR01T'])[1]" )
	private WebElement click   ;
	
	public List<WebElement> getText() {
		return text;
	}

	public WebElement getClick() {
		return click;
	}

	public Result(WebDriver p) {
		this.p=p;
		PageFactory.initElements(p, this);
	}
	

}
