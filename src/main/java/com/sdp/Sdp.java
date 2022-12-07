package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Sdp {
	public WebDriver p;
	
	public Search sr;
	public Result rs;
	
	public Search getSearch() {
		if(sr==null) {
			sr= new Search(p);	
		}
		return sr;
	}
	
	public Result getResult() {
		if(rs==null) {
			rs= new Result(p);
		}
		return rs;
	}
	 public Sdp(WebDriver p) {
		 this.p=p;
		 PageFactory.initElements(p,this);
	 }
	

}
