package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	public WebDriver p;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement button;

	@FindBy(xpath ="//div[@class='col-12-12 _2oO9oE']/child::div/child::input" )
	private WebElement iphone  ;
		
	@FindBy(xpath ="//div[@class='col-12-12 _2oO9oE']/child::button" )
	private WebElement search ;
	
	public WebElement getButton() {
		return button;
	}

	public WebElement getIphone() {
		return iphone;
	}

	public WebElement getSearch() {
		return search;
	}
	public Search(WebDriver p) {
		this.p=p;
		PageFactory.initElements(p, this);
	}
	
	
	
	

}
