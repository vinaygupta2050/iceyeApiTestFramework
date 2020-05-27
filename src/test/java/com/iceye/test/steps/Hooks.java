package com.iceye.test.steps;

import com.iceye.utils.PropertyFileReader;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author in-vinaykumar.gupta on 26/05/20
 * @project IntelliJ IDEA
 */
public class Hooks {

    public static RequestSpecification requestSpec;
    public static final Logger logger = LogManager.getLogger(Hooks.class);

    //In this method we are creating Request specification instance
    public static void setRequestSpec()
    {
        String baseUrl=PropertyFileReader.getAllProperties().get("serverUrl");
        logger.info("Setting base url : "+baseUrl);
        RestAssured.baseURI = baseUrl;
        requestSpec= RestAssured.given();
    }
    @Before
    public void beforeHook(Scenario scenario) {
        logger.info("Scenario name: "+scenario.getName());
        setRequestSpec();
    }
    public static RequestSpecification getRequestSpec()
    {
        return requestSpec;
    }
}
