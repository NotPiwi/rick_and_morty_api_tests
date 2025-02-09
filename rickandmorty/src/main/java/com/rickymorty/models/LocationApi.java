package com.rickymorty.models;

import com.rickymorty.api.BaseApi;
import com.rickymorty.utils.ApiValidator;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void invalidLocationTest(){
        Response response = baseApi.getElementByid("/location/", 12345);
        apiValidator.verifyStatusCode(response, 200);
    }
    /**
     * Verifica que la respuesta para el location con ID 123 contenga los siguientes campos y valores:
     *   "id": 123,
     *   "name": "Normal Size Bug Dimension",
     *   "type": "Dimension",
     *   "dimension": "",
     *   "url": "https://rickandmortyapi.com/api/location/123",
     *   "created": "2021-11-02T13:03:21.307Z"
     * Además, se verifica que el arreglo "residents" contenga:
     *   - Primer residente: "https://rickandmortyapi.com/api/character/795"
     *   - Segundo residente: "https://rickandmortyapi.com/api/character/796"
     */
    public void verifyLocation123Content(){
        Response response = baseApi.getElementByid("/location/", 123);
        apiValidator.verifyStatusCode(response, 200);
        Map<String, Object> location = response.jsonPath().getMap("");

        Map<String, Object> expectedContent = new HashMap<>();
        expectedContent.put("id", 123);
        expectedContent.put("name", "Normal Size Bug Dimension");
        expectedContent.put("type", "Dimension");
        expectedContent.put("dimension", "");
        expectedContent.put("url", "https://rickandmortyapi.com/api/location/123");
        expectedContent.put("created", "2021-11-02T13:03:21.307Z");

        apiValidator.verifyJsonContent(location, expectedContent);

        List<String> residents = (List<String>) location.get("residents");
        Assert.assertNotNull(residents, "El campo 'residents' es nulo");
        Assert.assertEquals(residents.size(), 2, "El número de residentes no coincide");
        Assert.assertEquals(residents.get(0), "https://rickandmortyapi.com/api/character/795", "El primer residente no coincide");
        Assert.assertEquals(residents.get(1), "https://rickandmortyapi.com/api/character/796", "El segundo residente no coincide");
    }
    /**
     * Verifica intencionalmente que el location 1 tenga el nombre "Mars".
     * Dado que la respuesta real es "Earth (C-137)", este test debe fallar.
     */
    public void verifyLocation1ShouldHaveMars(){
        Response response = baseApi.getElementByid("/location/", 1);
        apiValidator.verifyStatusCode(response, 200);
        Map<String, Object> location = response.jsonPath().getMap("");

        // Intencionalmente falla si el nombre es distinto de "Mars" (la respuesta real es "Earth (C-137)")
        Assert.assertEquals(location.get("name"), "Mars", "El nombre no es 'Mars' como se esperaba (test intencionalmente fallido)");
    }

}
