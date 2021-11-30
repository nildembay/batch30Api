package com.techproed.day13;

import com.google.gson.Gson;
import com.techproed.pojos.Data;
import com.techproed.pojos.DummyPojo;
import com.techproed.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;

public class GetRequestWithPojo01 extends DummyTestBase {

    /*
GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
                            Status code is 200
                                 {
                                  "status": "success",
                                  "data": {
                                      "id": 1,
                                      "employee_name": "Tiger Nixon",
                                      "employee_salary": 320800,
                                      "employee_age": 61,
                                      "profile_image": ""
                                  },
                                  "message": "Successfully! Record has been fetched."
                                 }

 */

    @Test
    public void test(){

        spec03.pathParams("parametre1","employee",
                "parametre2",1);

        Data data=
             new Data(1,"Tiger Nixon",320800,61,"");

        DummyPojo expectedData=
                new DummyPojo("success",data,"Successfully! Record has been fetched.");

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec03).
                when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        DummyPojo actualData=response.as(DummyPojo.class);
        System.out.println(actualData);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getData().getemployee_name(),
                actualData.getData().getemployee_name() );
        Assert.assertEquals(expectedData.getData().getId(),
                actualData.getData().getId());
        Assert.assertEquals(expectedData.getData().getemployee_age(),
                actualData.getData().getemployee_age());
        Assert.assertEquals(expectedData.getData().getemployee_salary(),
                actualData.getData().getemployee_salary());

        Assert.assertEquals(expectedData.getData().getprofile_image(),
                actualData.getData().getprofile_image());

        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());

//----------------------------------------------------
        //Serializaztion java yapısında olan dataları json formatına dönüştürme işlemidir.
        //Gson sınıfından bir obje üretilir

        Gson gson=new Gson();
        String jsonFromJava=gson.toJson(actualData);
        System.out.println(jsonFromJava);

















    }

}
