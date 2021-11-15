package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

/*
    https://restful-booker.herokuapp.com/booking url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    content type'inin "application/json" oldugunu test edin

     */

    @Test
    public void test01(){

        //url oluştur
        String url="https://restful-booker.herokuapp.com/booking";

        //expected datayı oluştur(body gerekmediği için oluşturmuyoruz)

        //request gönder

        Response response= given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json");

    }

    /*
           https://restful-booker.herokuapp.com/booking/1001 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 404 oldugunu
    ve Response body'sinin "Not Found" icerdigini
    ve Response body'sinin "API" icermedigini test edin
         */

    @Test
    public void test02(){
        //url oluştur
        String url="https://restful-booker.herokuapp.com/booking/1001";

        //expected data ---

        // request gönder

     Response response=given().
             accept("application/json").
             when().
             get(url);

     response.prettyPrint();


     response.then().assertThat().statusCode(404);
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("API"));
        // asString metodu ile json formatında gelen response u Stringe çevirdik



    }


    @Test
    public void test3(){
        String url="https://restful-booker.herokuapp.com/booking/1001";
        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(404);
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("API"));
    }



}
