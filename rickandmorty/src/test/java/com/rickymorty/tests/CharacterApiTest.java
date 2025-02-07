package com.rickymorty.tests;

import com.rickymorty.api.CharacterApi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CharacterApiTest {

    private CharacterApi characterApi;

    @BeforeClass public void setup() {
        characterApi = new CharacterApi();
    }
    @Test public void testStatusCode() {
        characterApi.getFirstCharacterAndVerifyStatus();
    }
    @Test public void testResponseBody() {
        characterApi.getFirstCharacterAndVerifyBody();
    }
    @Test public void testResponseHeaders() {
        characterApi.getFirstHeaderAndVerify();
    }
}
