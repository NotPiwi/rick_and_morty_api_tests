package com.rickymorty.api;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class LocationApi extends BaseApi {

    private final List<String> expectedFields = Arrays.asList("id", "name", "type", "dimension", "residents", "url", "created");

    public void getFirstLocationAndVerifyStatus(){
        Response response = getElementByid("/location/", 1);
        verifyStatusCode(response, 200);
        response = getElementByid("/location/", 9999);
        verifyStatusCode(response, 404);
    }

    public void getFirstLocationAndVerifyBody(){
        Response response = getElementByid("/location/", 1);
        verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = getElementByid("/location/", 1);
        verifyHeader(response);
    }
}
