package com.rickymorty.api;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class EpisodeApi extends BaseApi {

    private final List<String> expectedFields = Arrays.asList("id", "name","air_date", "episode", "characters", "url", "created");


    public void getFirstEpisodeAndVerifyStatus() {
        Response response = getElementByid("/episode/", 1);
        verifyStatusCode(response, 200);
        response = getElementByid("/episode/", 9999);
        verifyStatusCode(response, 404);
    }

    public void getFirstEpisodeAndVerifyBody(){
        Response response = getElementByid("/episode/",1);
        verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = getElementByid("/episode/",1);
        verifyHeader(response);
    }
}
