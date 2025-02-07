package com.rickymorty.api;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class CharacterApi extends BaseApi {

    private final List<String> expectedFields = Arrays.asList("id", "name","status", "species", "type", "gender", "origin", "location", "image", "episode", "url", "created");

    public void getFirstCharacterAndVerifyStatus(){
        Response response = getElementByid("/character/", 1);
        verifyStatusCode(response, 200);
        response = getElementByid("/character/", 9999);
        verifyStatusCode(response, 404);
    }

    public void getFirstCharacterAndVerifyBody(){
        Response response = getElementByid("/character/", 1);
        verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = getElementByid("/character/", 1);
        verifyHeader(response);
    }
}
