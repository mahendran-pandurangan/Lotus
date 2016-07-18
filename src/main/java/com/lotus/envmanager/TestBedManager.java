package com.lotus.envmanager;

public class TestBedManager {

	public static String env = "";
	public static Object browserType = "";


	public String getEnv() {
		String env = System.getProperty("env");
	    return env;  
	}
	
	public String getBrowserType(){
		String browserType = System.getProperty("browserType");
		return browserType;
	}

}
