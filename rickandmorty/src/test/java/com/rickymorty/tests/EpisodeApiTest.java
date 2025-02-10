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
    public void testEpisodeStatusCode() {
        episodeApi.getFirstEpisodeAndVerifyStatus();
    }
    @Test
    public void testEpisodeBody() {
        logger.info("   🦍 Verificando los campos del body del episodio 1...");
        episodeApi.getFirstEpisodeAndVerifyBody();
    }
    @Test
    public void testEpisodeHeaders() {
        logger.info("   🦍 Verificando el header del episodio 1...");
        episodeApi.getFirstHeaderAndVerify();
    }
    @Test
    public void testEpisode5Content() {
        logger.info("   🦍 Verificando contenido del episodio 5...");
        episodeApi.verifyEpisode5Content();
    }
}
