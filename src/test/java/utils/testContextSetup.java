package utils;

import java.io.IOException;

import pageObjects.PageObjectManager;

public class testContextSetup {
	public static TestBase testbase;
	public PageObjectManager pageobjectmanager;

	
	public testContextSetup() throws IOException
	{
		 testbase = new TestBase();
		 pageobjectmanager = new PageObjectManager(testbase.initilizeBrowser());
		
	}
}
