package com.lotus.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:config/default/beans.xml" })
public class App extends AbstractTestNGSpringContextTests {

	@Autowired
	Config config;

	@Test
	public void testMethod() {

		System.out.println(config.getBaseUrl().toString());
		System.out.println(config.getBrowserType().toString());

	}

}
