package com.rickymorty.tests;

import com.rickymorty.api.LocationApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocationApiTest {

    private LocationApi locationApi;

    @BeforeClass
    public void setup() {
        locationApi = new LocationApi();
    }
    @Test
    public void testStatusCode() {
        locationApi.getFirstLocationAndVerifyStatus();
    }
    @Test public void testResponseBody() {
        locationApi.getFirstLocationAndVerifyBody();
    }
    @Test public void testResponseHeaders() {
        locationApi.getFirstHeaderAndVerify();
    }
}
