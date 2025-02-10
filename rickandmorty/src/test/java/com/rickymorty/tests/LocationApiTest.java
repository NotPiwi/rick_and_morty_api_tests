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
        logger.info("   🦍 Verificando los campos del body del location 1...");
        locationApi.getFirstLocationAndVerifyBody();
    }
    @Test
    public void testLocationHeaders() {
        logger.info("   🦍 Verificando el header del location 1...");
        locationApi.getFirstHeaderAndVerify();
    }
    @Test
    public void location123Content(){
        logger.info("   🦍 Verificando el contenido del location 123...");
        locationApi.verifyLocation123Content();
    }

}
