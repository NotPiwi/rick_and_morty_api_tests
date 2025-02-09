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
        episodeApi.getFirstEpisodeAndVerifyBody();
    }
    @Test
    public void testEpisodeHeaders() {
        episodeApi.getFirstHeaderAndVerify();
    }
}
