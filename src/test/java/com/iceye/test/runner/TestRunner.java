package com.iceye.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author in-vinaykumar.gupta on 26/05/20
 * @project IntelliJ IDEA
 * Info: This class is an entry point for test suite from where the test case will be intitaited to run.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/iceye/test/features"} , plugin = {"json:target/cucumber.json"},
        glue = "com.iceye.test.steps")
public class TestRunner {

}
