package com.rickymorty.utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import static org.testng.Assert.assertEquals;

public class ApiValidator {

    public void verifyStatusCode(Response response, int statuscode){
        assertEquals(response.statusCode(), statuscode, "El código de respuesta no es " + statuscode);
    }

    public void verifyFields(List<String> expectedFields, Map<String, Object> fields){
        for (String field : expectedFields) {
            Assert.assertTrue(fields.containsKey(field), "Falta el campo: " + field);
            Assert.assertNotNull(fields.get(field), "El campo '" + field + "' es null");
        }
    }

    public void verifyHeader(Response response){
        String contentType = response.getHeader("Content-Type");
        assertEquals(contentType, "application/json; charset=utf-8", "El Content-Type no es correcto");
    }

    public void verifyJsonContent(Map<String, Object> actual, Map<String, Object> expected) {
        for (Map.Entry<String, Object> entry : expected.entrySet()) {
            assertEquals(actual.get(entry.getKey()), entry.getValue(), "El campo " + entry.getKey() + " no coincide");
        }
    }
}
