package org.assessment.apimissions;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class ExchangeRateApi {

    //Method hits the API endpoint using RestAssured & gets the response
    public Response getRatesForUrl(String url) {
        RestAssured.baseURI=url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        return response;
    }
}
