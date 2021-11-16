package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {
/*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
      5. Çalışan isminin "Airi Satou" olduğunu ,
      çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
11. Çalışan bilgilerinin
    {
 “id”:”11”
        "employee_name": "Jena Gaines",
            "employee_salary": "90560",
            "employee_age": "30",
            "profile_image": "" }
} gibi olduğunu test edin.
*/

    @Test
    public void test(){
        spec03.pathParam("parametre1","employees");

        DummyTestData expectedObje=new DummyTestData();
        HashMap<String,Object> expectedDataMap=expectedObje.setUpTestData();
        System.out.println(expectedDataMap);

        Response response= given().
                        accept("application/json").
                        spec(spec03).
                        when().
                        get("/{parametre1}");

        response.prettyPrint();




    }




}
