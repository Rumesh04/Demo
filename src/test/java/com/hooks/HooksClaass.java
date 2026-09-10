package com.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClaass extends BaseClass{
	
	@Before
	public static void start() {
		BaseClass.browserLaunch();
		driver.manage().window().maximize();
	}

	@After
	public void tear(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String screenShotPath = screenShot(driver, scenario.getName());
			byte[] screenShot = Files.readAllBytes(new File(screenShotPath).toPath());
			scenario.attach(screenShot, "image/png", scenario.getName());
		}
	}

}


