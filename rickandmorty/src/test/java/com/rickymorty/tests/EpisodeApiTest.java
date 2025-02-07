package com.rickymorty.tests;

import com.rickymorty.api.EpisodeApi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EpisodeApiTest {

    private EpisodeApi episodeApi;

    @BeforeClass public void setup() {
        episodeApi = new EpisodeApi();
    }
    @Test
    public void testStatusCode() {
        episodeApi.getFirstEpisodeAndVerifyStatus();
    }
    @Test public void testResponseBody() {
        episodeApi.getFirstEpisodeAndVerifyBody();
    }
    @Test public void testResponseHeaders() {
        episodeApi.getFirstHeaderAndVerify();
    }
}
