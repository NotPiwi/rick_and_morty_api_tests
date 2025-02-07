package com.rickymorty.models;

import com.rickymorty.api.BaseApi;
import com.rickymorty.utils.ApiValidator;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class LocationApi {

    private final BaseApi baseApi;
    private final ApiValidator apiValidator;

    public LocationApi() {
        this.baseApi = new BaseApi();
        this.apiValidator = new ApiValidator();
    }

    private final List<String> expectedFields = Arrays.asList("id", "name", "type", "dimension", "residents", "url", "created");

    public void getFirstLocationAndVerifyStatus(){
        Response response = baseApi.getElementByid("/location/", 1);
        apiValidator.verifyStatusCode(response, 200);
        response = baseApi.getElementByid("/location/", 9999);
        apiValidator.verifyStatusCode(response, 404);
    }

    public void getFirstLocationAndVerifyBody(){
        Response response = baseApi.getElementByid("/location/", 1);
        apiValidator.verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = baseApi.getElementByid("/location/", 1);
        apiValidator.verifyHeader(response);
    }
}
