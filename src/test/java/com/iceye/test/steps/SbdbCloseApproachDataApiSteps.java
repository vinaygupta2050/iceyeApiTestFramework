package com.iceye.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.HashMap;

/**
 * @author in-vinaykumar.gupta on 26/05/20
 * @project IntelliJ IDEA
 * @Info: This class is step definition of SbdbCloseApproachDataApiSteps.feature file so it consist all the defenition
 * of the steps used in feature file
 */
public class SbdbCloseApproachDataApiSteps {

    //We are getting RequestSpecfication Object with wich we will be validating apis. RequestSpec object is initialised at the start of the test.
    public RequestSpecification httpRequest = Hooks.getRequestSpec();
    public String apiEndPoint;
    public HashMap<String, String> queryParam = new HashMap<String, String>();
    public Response rs;
    public static final Logger log = LogManager.getLogger(SbdbCloseApproachDataApiSteps.class);

    @Given("I want to execute service {string}")
    public void i_want_to_execute_service(String endPoint) {

        log.info("Setting up End point as :" + endPoint);
        apiEndPoint = endPoint;

    }

    @When("I add query parameter key as {string} and value as {string}")
    public void i_add_query_parameter_key_as_and_value_as(String key, String value) {

        log.info("Setting up Query Params as : (" + key + "," + value + ")");
        httpRequest.queryParam(key, value);

    }

    @When("I submit the GET request")
    public void i_submit_the_GET_request() {

        log.info("Sending GET Request to the server");
        rs = httpRequest.request(Method.GET, apiEndPoint);

    }

    @Then("I validate that response status code is {int}")
    public void i_validate_that_response_status_code_is(Integer statusCode) {

        log.info("Response status code is :" + rs.getStatusCode());
        Assert.assertEquals(statusCode, new Integer(rs.getStatusCode()));

    }

    @Then("I validate that response contains data with timestamp {string}")
    public void i_validate_that_response_contains_data_with_timestamp(String timeStamp) {
        //In this test we are using jsonPath method to navigate through json objects
        Assert.assertTrue(rs.getBody().jsonPath().getString("data").contains(timeStamp));

    }

    @Then("I validate response with json schema {string}")
    public void i_validate_response_with_json_schema(String schemaName) {

        //In this test we are using rest assured JsonSchemaValidator to validate response json against schema
        rs.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaName));

    }

    @Then("I validate that response data with timestamp {string} is present at position {int}")
    public void i_validate_that_response_data_with_timestamp_is_present_at_position(String timeStamp, Integer position) {

        Assert.assertTrue(rs.getBody().jsonPath().getString("data[" + position + "]").contains(timeStamp));

    }

    @Then("I validate that response contains total {int} records")
    public void i_validate_that_response_contains_total_records(Integer totalRecords) {

        log.info("Total records present in response is: " + rs.getBody().jsonPath().getString("count"));
        Assert.assertEquals(totalRecords, new Integer(rs.getBody().jsonPath().getString("count")));
    }

    @Then("I validate that response contains message as {string}")
    public void i_validate_that_response_contains_message_as(String message) {
        // Write code here that turns the phrase above into concrete actions
        log.info("Response contains message as :"+rs.getBody().jsonPath().getString("message"));
        Assert.assertEquals(message,rs.getBody().jsonPath().getString("message"));
    }
}
