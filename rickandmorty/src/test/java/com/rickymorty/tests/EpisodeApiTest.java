package com.rickymorty.tests;

import com.rickymorty.models.EpisodeApi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EpisodeApiTest extends BaseTest{

    private EpisodeApi episodeApi;

    @BeforeClass
    public void setup() {
        episodeApi = new EpisodeApi();
    }
    @Test
    public void testStatusCode() {
        logger.info("🔍 Ejecutando testEpisodeStatus...");
        episodeApi.getFirstEpisodeAndVerifyStatus();
    }
    @Test
    public void testResponseBody() {
        logger.info("🔍 Ejecutando testEpisodeBody...");
        episodeApi.getFirstEpisodeAndVerifyBody();
    }
    @Test
    public void testResponseHeaders() {
        logger.info("🔍 Ejecutando testEpisodeHeaders...");
        episodeApi.getFirstHeaderAndVerify();
    }
    @Test
    public void testEpisodeFail() { // Forzamos fallo con un episodio que no existe
        logger.info("🔍 Ejecutando testEpisodeFail...");
        episodeApi.invalidEpisodeTest();
    }
    @Test
    public void testEpisode5Content() {
        logger.info("🔍 Ejecutando testEpisode5Content para verificar contenido del episodio 5...");
        episodeApi.verifyEpisode5Content();
    }
    @Test
    public void testEpisode5ContainsCharacter3ShouldFail() { // Forzamos fallo con un character que no existe en el episodio 5
        logger.info("🔍 Ejecutando testEpisode5ContainsCharacter3ShouldFail para verificar que el character 3 está presente (este test debe fallar)...");
        episodeApi.verifyEpisode5ContainsCharacter3();
    }
}
