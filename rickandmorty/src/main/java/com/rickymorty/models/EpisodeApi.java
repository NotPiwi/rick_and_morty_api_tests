package com.rickymorty.models;

import com.rickymorty.api.BaseApi;
import com.rickymorty.utils.ApiValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class EpisodeApi {

    private final BaseApi baseApi;
    private final ApiValidator apiValidator;

    public EpisodeApi() {
        this.baseApi = new BaseApi();
        this.apiValidator = new ApiValidator();
    }

    private final List<String> expectedFields = Arrays.asList("id", "name","air_date", "episode", "characters", "url", "created");

    public void getFirstEpisodeAndVerifyStatus() {
        Response response = baseApi.getElementByid("/episode/", 1);
        apiValidator.verifyStatusCode(response, 200);
        response = baseApi.getElementByid("/episode/", 9999);
        apiValidator.verifyStatusCode(response, 404);
    }

    public void getFirstEpisodeAndVerifyBody(){
        Response response = baseApi.getElementByid("/episode/",1);
        apiValidator.verifyFields(expectedFields,response.jsonPath().get());
    }

    public void getFirstHeaderAndVerify(){
        Response response = baseApi.getElementByid("/episode/",1);
        apiValidator.verifyHeader(response);
    }
    /**
     * Verifica el contenido del episodio 5 (Meeseeks and Destroy) comprobando los siguientes campos:
     *   "id": 5,
     *   "name": "Meeseeks and Destroy",
     *   "air_date": "January 20, 2014",
     *   "episode": "S01E05",
     *   "url": "https://rickandmortyapi.com/api/episode/5",
     *   "created": "2017-11-10T12:56:34.236Z"
     * Además, verifica que el arreglo "characters" contenga:
     *   - Primer elemento: "https://rickandmortyapi.com/api/character/1"
     *   - Segundo elemento: "https://rickandmortyapi.com/api/character/2"
     *   - Último elemento: "https://rickandmortyapi.com/api/character/400"
     */
    public void verifyEpisode5Content(){
        Response response = baseApi.getElementByid("/episode/", 5);
        apiValidator.verifyStatusCode(response, 200);

        Map<String, Object> episode = response.jsonPath().getMap("");

        Map<String, Object> expectedContent = new HashMap<>();
        expectedContent.put("id", 5);
        expectedContent.put("name", "Meeseeks and Destroy");
        expectedContent.put("air_date", "January 20, 2014");
        expectedContent.put("episode", "S01E05");
        expectedContent.put("url", "https://rickandmortyapi.com/api/episode/5");
        expectedContent.put("created", "2017-11-10T12:56:34.236Z");

        apiValidator.verifyJsonContent(episode, expectedContent);

        List<String> characters = (List<String>) episode.get("characters");
        Assert.assertNotNull(characters, "El campo 'characters' es nulo");
        Assert.assertFalse(characters.isEmpty(), "El arreglo 'characters' está vacío");

        Assert.assertEquals(characters.get(0), "https://rickandmortyapi.com/api/character/1", "El primer carácter no coincide");
        Assert.assertEquals(characters.get(1), "https://rickandmortyapi.com/api/character/2", "El segundo carácter no coincide");
        Assert.assertEquals(characters.get(characters.size()-1), "https://rickandmortyapi.com/api/character/400", "El último carácter no coincide");
    }
}
