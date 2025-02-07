package com.rickymorty.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BaseApi {

    public BaseApi(){
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }

    public Response getElementByid(String Endpoint, int id){
        return given()
                .when().get(Endpoint + id)
                .then().extract().response();
    }
}
