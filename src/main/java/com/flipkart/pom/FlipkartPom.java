package com.flipkart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPom {
public WebDriver p=null;

@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
private WebElement button;

@FindBy(xpath ="//div[@class='col-12-12 _2oO9oE']/child::div/child::input" )
private WebElement iphone  ;
	
@FindBy(xpath ="//div[@class='col-12-12 _2oO9oE']/child::button" )
private WebElement search ;

@FindBy(xpath ="//div[@class='_4rR01T']" )
private WebElement  text ;

@FindBy(xpath ="(//div[@class='_4rR01T'])[1]" )
private WebElement click   ;

public WebElement getButton() {
	return button;
}

public WebElement getIphone() {
	return iphone;
}

public WebElement getSearch() {
	return search;
}

public WebElement getText() {
	return text;
}

public WebElement getClick() {
	return click;
}

public FlipkartPom(WebDriver p) {
	this.p=p;
	PageFactory.initElements(p, this);
}

	
	
	
	
	
	
	
	
	
}
