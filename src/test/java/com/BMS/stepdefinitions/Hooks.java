package com.BMS.stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
		features = {"Feature/"},
			plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"},
		tags = {"@lo"}
	  )

	public class Hooks {
		
	}


