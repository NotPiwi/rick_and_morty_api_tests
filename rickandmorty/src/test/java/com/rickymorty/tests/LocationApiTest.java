package com.rickymorty.tests;

import com.rickymorty.models.LocationApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocationApiTest extends BaseTest{

    private LocationApi locationApi;

    @BeforeClass
    public void setup() {
        locationApi = new LocationApi();
    }
    @Test
    public void testStatusCode() {
        logger.info("🔍 Ejecutando testLocationStatus...");
        locationApi.getFirstLocationAndVerifyStatus();
    }
    @Test
    public void testResponseBody() {
        logger.info("🔍 Ejecutando testLocationBody...");
        locationApi.getFirstLocationAndVerifyBody();
    }
    @Test
    public void testResponseHeaders() {
        logger.info("🔍 Ejecutando testLocationHeaders...");
        locationApi.getFirstHeaderAndVerify();
    }
}
