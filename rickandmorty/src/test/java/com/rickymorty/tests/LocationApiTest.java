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
    @Test
    public void testInvalidLocation(){ //Falla intencionalmente (locacion no existente)
        logger.info("🔍 Ejecutando testInvalidLocation...");
        locationApi.invalidLocationTest();
    }
    @Test
    public void location123Content(){
        logger.info("🔍 Ejecutando location123Content para verificar el contenido del location 123...");
        locationApi.verifyLocation123Content();
    }
    @Test
    public void testLocation1ShouldHaveMarsFailure() {
        logger.info("🔍 Ejecutando testLocation1ShouldHaveMarsFailure (este test debe fallar)...");
        locationApi.verifyLocation1ShouldHaveMars();
    }

}
