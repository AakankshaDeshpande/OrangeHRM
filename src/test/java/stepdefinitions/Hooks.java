package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.testContextSetup;

public class Hooks {
	testContextSetup testcontextsetup;
	
	public Hooks(testContextSetup testcontextsetup)
	{
		this.testcontextsetup = testcontextsetup;
	}
	@After
	public void AfterScenario() throws IOException
	{
		//testcontextsetup.testbase.initilizeBrowser().quit();
	}
	
}
