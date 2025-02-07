package com.rickymorty.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BaseApi {

    public BaseApi(){
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }

    public Response getElementByid(String Endpoint, int id){
        return given()
                .when().get(Endpoint + id)
                .then().extract().response();
    }

    public void verifyStatusCode(Response response, int statuscode){
        assertEquals(response.statusCode(), statuscode, "El código de respuesta no es " + statuscode);
        System.out.println("🦍🗿🗿 Status Code " + statuscode + " verificado correctamente.");
    }

    public void verifyFields(List<String> expectedFields, Map<String, Object> fields){
        for (String field : expectedFields) {
            Assert.assertTrue(fields.containsKey(field), "Falta el campo: " + field);
            Assert.assertNotNull(fields.get(field), "El campo '" + field + "' es null");
        }
        System.out.println("🗿🦍🗿 Estructura verificada correctamente.");
    }

    public void verifyHeader(Response response){
        String contentType = response.getHeader("Content-Type");
        assertEquals(contentType, "application/json; charset=utf-8", "El Content-Type no es correcto");
        System.out.println("🗿🗿🦍 Content-Type verificado correctamente.");
    }
}
