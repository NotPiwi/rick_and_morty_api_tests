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
    public void testLocationStatusCode() {
        locationApi.getFirstLocationAndVerifyStatus();
    }
    @Test
    public void testLocationBody() {
        locationApi.getFirstLocationAndVerifyBody();
    }
    @Test
    public void testLocationHeaders() {
        locationApi.getFirstHeaderAndVerify();
    }
}
