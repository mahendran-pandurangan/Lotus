package com.lotus.envmanager;

public class TestBedManager {

	public static String env = "qa";
	public static Object browserType = "firefox";


	public String getEnv() {
		//String env = System.getProperty("env");
	    return env;  
	}
	
	public Object getBrowserType(){

		return browserType;
	}

}
