package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",

                 glue = "com.hrms.steps",

               // dryRun=true,
                 
                 monochrome = true,
                 
                 tags="@dash"
                 
                 //strict = true

)

public class practiceRunner {

}
