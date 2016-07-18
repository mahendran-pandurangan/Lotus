package com.lotus.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	private String baseUrl;
	private String browserType;

	public String getBaseUrl() {
		return baseUrl;
	}

	@Autowired
	public void setBaseUrl(@Value("${baseUrl}")String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getBrowserType() {
		return browserType;
	}

	@Autowired
	public void setBrowserType(@Value("${browserType}")String browserType) {
		this.browserType = browserType;
	}

	@Override
	public String toString() {
		return "Config [baseUrl=" + baseUrl + ", browserType=" + browserType + "]";
	}

	
}
