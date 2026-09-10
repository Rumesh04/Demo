package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\LENOVO\\Desktop\\PhpTravel\\src\\test\\resources\\Feature\\PhpTravels.feature", glue = {
		"com.stepdefinition", "com.hooks" }, monochrome = !true, dryRun = !true, plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class TestRunner {

}
