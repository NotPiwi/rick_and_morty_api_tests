package com.rickymorty.models;

import com.rickymorty.api.BaseApi;
import com.rickymorty.utils.ApiValidator;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class EpisodeApi {

    private final BaseApi baseApi;
    private final ApiValidator apiValidator;

    public EpisodeApi() {
        this.baseApi = new BaseApi();
        this.apiValidator = new ApiValidator();
    }

    private final List<String> expectedFields = Arrays.asList("id", "name","air_date", "episode", "characters", "url", "created");

    public void getFirstEpisodeAndVerifyStatus() {
        Response response = baseApi.getElementByid("/episode/", 1);
        apiValidator.verifyStatusCode(response, 200);
        response = baseApi.getElementByid("/episode/", 9999);
        apiValidator.verifyStatusCode(response, 404);
    }

    public void getFirstEpisodeAndVerifyBody(){
        Response response = baseApi.getElementByid("/episode/",1);
        apiValidator.verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = baseApi.getElementByid("/episode/",1);
        apiValidator.verifyHeader(response);
    }
}
