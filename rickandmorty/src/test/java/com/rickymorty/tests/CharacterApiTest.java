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
    public void testCharacterStatusCode() {
        characterApi.getFirstCharacterAndVerifyStatus();
    }
    @Test
    public void testCharacterBody() {
        logger.info("   🦍 Verificando los campos del body del personaje 1...");
        characterApi.getFirstCharacterAndVerifyBody();
    }
    @Test
    public void testCharacterHeaders() {
        logger.info("   🦍 Verificando el header del personaje 1...");
        characterApi.getFirstHeaderAndVerify();
    }
    @Test
    public void testCharacter183Content() {
        logger.info("   🦍 Verificando contenido del personaje con ID 183 (Johnny Depp)...");
        characterApi.verifyCharacter183Content();
    }

}
