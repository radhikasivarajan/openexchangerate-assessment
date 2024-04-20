package org.assessment.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assessment.apimissions.ExchangeRateApi;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.LinkedHashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExchangeRateSteps {

    public static Response response;
    public ExchangeRateApi exchangeRateApi= new ExchangeRateApi();


    @When("I hit the open ER API {string}")
    public void iHitTheOpenERAPIHttpsOpenErApiComVLatestUSD(String url) {
        response= exchangeRateApi.getRatesForUrl(url);
    }

    @Then("a {int} status code is returned")
    public void aStatusCodeIsReturned(int status_code) {
        Assert.assertEquals(status_code, response.getStatusCode());
    }

    @And("the json schema is correct")
    public void theJsonSchemaIsCorrect() {
        assertThat(response.then().extract().body().asString(), matchesJsonSchemaInClasspath("testdata/schema.json"));
    }

    @And("the response field {string} is {string}")
    public void theResponseFieldIs(String field, String exp_value) {
        String actual_value = response.getBody().jsonPath().get(field);
        Assert.assertEquals(exp_value,actual_value);
    }


    @And("the AED rate is in the range {string} - {string}")
    public void theAEDRateIsInTheRange(String low, String high ) {
        Float aed_rate=response.getBody().jsonPath().get("rates.AED");
        Assert.assertTrue(aed_rate > Float.parseFloat(low)) ;
        Assert.assertTrue(aed_rate < Float.parseFloat(high));
    }

    @And("the number of currency pairs returned is {string}")
    public void theNumberOfCurrencyPairsReturnedIs(String currencyCount) {
        LinkedHashMap<String, String> records = response.getBody().jsonPath().getJsonObject("rates");
        Assert.assertEquals(Integer.parseInt(currencyCount), records.size());
    }
}

