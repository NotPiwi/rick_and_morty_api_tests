package com.rickymorty.models;

import com.rickymorty.api.BaseApi;
import com.rickymorty.utils.ApiValidator;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterApi {

    private final BaseApi baseApi;
    private final ApiValidator apiValidator;

    public CharacterApi() {
        this.baseApi = new BaseApi();
        this.apiValidator = new ApiValidator();
    }

    // Lista de campos obligatorios que se esperan en cualquier respuesta de personaje.
    private final List<String> expectedFields = Arrays.asList(
            "id", "name", "status", "species", "type", "gender",
            "origin", "location", "image", "episode", "url", "created"
    );

    public void getFirstCharacterAndVerifyStatus(){
        Response response = baseApi.getElementByid("/character/", 1);
        apiValidator.verifyStatusCode(response, 200);
        response = baseApi.getElementByid("/character/", 9999);
        apiValidator.verifyStatusCode(response, 404);
    }

    public void getFirstCharacterAndVerifyBody(){
        Response response = baseApi.getElementByid("/character/", 1);
        apiValidator.verifyFields(expectedFields, response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = baseApi.getElementByid("/character/", 1);
        apiValidator.verifyHeader(response);
    }

    /**
     * Verifica que la respuesta para el personaje con ID 183 (Johnny Depp) contenga los siguientes campos y valores:
     *   "id": 183,
     *   "name": "Johnny Depp",
     *   "status": "Alive",
     *   "species": "Human",
     *   "type": "",
     *   "gender": "Male",
     *   "url": "https://rickandmortyapi.com/api/character/183"
     */
    public void verifyCharacter183Content(){
        Response response = baseApi.getElementByid("/character/", 183);
        apiValidator.verifyStatusCode(response, 200);
        Map<String, Object> character = response.jsonPath().getMap("");

        Map<String, Object> expectedContent = new HashMap<>();
        expectedContent.put("id", 183);
        expectedContent.put("name", "Johnny Depp");
        expectedContent.put("status", "Alive");
        expectedContent.put("species", "Human");
        expectedContent.put("type", "");
        expectedContent.put("gender", "Male");
        expectedContent.put("url", "https://rickandmortyapi.com/api/character/183");

        apiValidator.verifyCharacterContent(character, expectedContent);
    }
}
