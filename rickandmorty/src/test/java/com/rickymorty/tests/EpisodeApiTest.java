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
}
