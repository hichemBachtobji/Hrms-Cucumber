package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",

                 glue = "com.hrms.steps",

                //dryRun=true,
                 
                 monochrome = true,
                 
                 tags="@dbhw",

                 //strict = true

plugin= {"pretty",
		"html:target/cucumber-default-report",
		"json:target/cucmber.json",
		"rerun:target/failed.txt"
		
}

)

public class practiceRunner {

}
