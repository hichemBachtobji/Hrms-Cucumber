package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",

                 glue = "com/hrms/API/steps/practice",

                //dryRun=true,
                 
                 monochrome = true,
                 
                 tags="@workflow",

                 //strict = true

plugin= {"pretty",
		"html:target/cucumber-default-report",
		"json:target/cucmber.json",
		"rerun:target/failed.txt"		
}
)



public class APIWorkflowRunner {

}
