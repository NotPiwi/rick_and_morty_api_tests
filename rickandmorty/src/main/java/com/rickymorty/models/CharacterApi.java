package com.rickymorty.models;

import com.rickymorty.api.BaseApi;
import com.rickymorty.utils.ApiValidator;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class CharacterApi{

    private final BaseApi baseApi;
    private final ApiValidator apiValidator;

    public CharacterApi() {
        this.baseApi = new BaseApi();
        this.apiValidator = new ApiValidator();
    }
    private final List<String> expectedFields = Arrays.asList("id", "name","status", "species", "type", "gender", "origin", "location", "image", "episode", "url", "created");

    public void getFirstCharacterAndVerifyStatus(){
        Response response = baseApi.getElementByid("/character/", 1);
        apiValidator.verifyStatusCode(response, 200);
        response = baseApi.getElementByid("/character/", 9999);
        apiValidator.verifyStatusCode(response, 404);
    }

    public void getFirstCharacterAndVerifyBody(){
        Response response = baseApi.getElementByid("/character/", 1);
        apiValidator.verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = baseApi.getElementByid("/character/", 1);
        apiValidator.verifyHeader(response);
    }
}
