package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuAppTestBase {

    protected RequestSpecification spec02;

    @Before
    public void setUp(){

        spec02= new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }

}
