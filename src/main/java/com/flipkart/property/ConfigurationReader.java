package com.flipkart.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	Properties p;
	public ConfigurationReader() throws IOException {
		File pH = new File("/Users/r.harish/eclipse-workspace/Flipkart/src/main/java/com/flipkart/property/flipkart.properties");
		FileInputStream f = new FileInputStream(pH);
		 p = new Properties();
		 p.load(f);
	}
public String getBrowser() {
String browser = p.getProperty("browser")	;
return browser;
}
public String getUrl() {
	String url = p.getProperty("url");
	return url;
}
public String getSheet() {
	String sheet = p.getProperty("sheet");
	return sheet;
}
}
