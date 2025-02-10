package com.rickymorty.utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;

public class ApiValidator {

    private static final Logger logger = LoggerFactory.getLogger(ApiValidator.class);

    public void verifyStatusCode(Response response, int statuscode){
        assertEquals(response.statusCode(), statuscode, "El código de respuesta no es " + statuscode);
    }

    public void verifyFields(List<String> expectedFields, Map<String, Object> fields){
        for (String field : expectedFields) {
            if (!fields.containsKey(field)) {
                logger.error("     ❌ FALTA el campo: {}", field);
                Assert.fail("     ❌ Falta el campo: " + field);
            } else if (fields.get(field) == null) {
                logger.warn("     ❌ El campo '{}' existe pero es NULL", field);
                Assert.fail("     ❌ El campo '" + field + "' es null");
            } else {
                logger.info("     ✅ Campo verificado correctamente: {}", field);
            }
        }
    }

    public void verifyHeader(Response response){
        String contentType = response.getHeader("Content-Type");
        assertEquals(contentType, "application/json; charset=utf-8", "El Content-Type no es correcto");
    }

    public void verifyJsonContent(Map<String, Object> actual, Map<String, Object> expected) {
        for (Map.Entry<String, Object> entry : expected.entrySet()) {
            Object actualValue = actual.get(entry.getKey());
            if (!entry.getValue().equals(actualValue)) {
                logger.error("     ❌ Error en campo '{}': esperado '{}', pero se obtuvo '{}'", entry.getKey(), entry.getValue(), actualValue);
                Assert.fail("     ❌ El campo '" + entry.getKey() + "' es distinto a lo esperado");
            } else {
                logger.info("     ✅ Campo '{}' validado correctamente: '{}'", entry.getKey(), actualValue);
            }
            assertEquals(actual.get(entry.getKey()), entry.getValue(), "El campo " + entry.getKey() + " no coincide");
        }
    }
}
