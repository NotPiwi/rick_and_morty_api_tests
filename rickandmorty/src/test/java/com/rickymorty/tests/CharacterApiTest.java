package com.rickymorty.tests;

import com.rickymorty.models.CharacterApi;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CharacterApiTest extends BaseTest{

    private CharacterApi characterApi;

    @BeforeClass
    public void setup() {
        characterApi = new CharacterApi();
    }
    @Test
    public void testStatusCode() {
        logger.info("🔍 Ejecutando testCharacterStatus...");
        characterApi.getFirstCharacterAndVerifyStatus();
    }
    @Test
    public void testResponseBody() {
        logger.info("🔍 Ejecutando testCharacterBody...");
        characterApi.getFirstCharacterAndVerifyBody();
    }
    @Test
    public void testResponseHeaders() {
        logger.info("🔍 Ejecutando testCharacterHeaders...");
        characterApi.getFirstHeaderAndVerify();
    }
    @Test
    public void testCharacterFail() {
        logger.info("🔍 Ejecutando testCharacterFail...");
        characterApi.invalidTest();
    }

}
