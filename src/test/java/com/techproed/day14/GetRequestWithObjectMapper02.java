package com.techproed.day14;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper02 extends HerokuAppTestBase {
    /*
    GetRequestWithObjectMapper02:
  https://restful-booker.herokuapp.com/booking/2 url’ine bir get request gönderildiğinde,
 status kodun 200 ve response body’nin
{
"firstname": "Susan",
"lastname": "Smith",
"totalprice": 401,
"depositpaid": true,
"bookingdates": {
"checkin": "2015-12-16",
"checkout": "2017-03-17"
},
"additionalneeds": "Breakfast"
}

Olduğunu Object Mapper kullanarak test edin
     */

    @Test
    public void test(){

        spec02.pathParams("parametre1", "booking",
                "parametre2",2);


        String jsonData="{\n" +
                "\"firstname\": \"Susan\",\n" +
                "\"lastname\": \"Smith\",\n" +
                "\"totalprice\": 401,\n" +
                "\"depositpaid\": true,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2015-12-16\",\n" +
                "\"checkout\": \"2017-03-17\"\n" +
                "},\n" +
                "\"additionalneeds\": \"Breakfast\"\n" +
                "}";

        HashMap<String,Object> expectedData= JsonUtil.convertJsonToJava(jsonData, HashMap.class);
        System.out.println(expectedData);

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec02).
                when().
                get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        HashMap<String,Object> actualData= JsonUtil.convertJsonToJava(response.asString(),HashMap.class);

        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),
                ((Map) actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),
                ((Map) actualData.get("bookingdates")).get("checkout"));












    }


}
