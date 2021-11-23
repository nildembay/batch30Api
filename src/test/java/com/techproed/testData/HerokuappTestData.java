package com.techproed.testData;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {
/*
    {
        "firstname": "Eric",
            "lastname": "Smith",
            "totalprice": 555,
            "depositpaid": false,
            "bookingdates": {
        "checkin": "2016-09-09",
                "checkout": "2017-09-21"
    }
    }
*/

    public HashMap<String, Object> setUpTestData(){

        HashMap<String ,Object> bookingdates=new HashMap<String, Object>();
        bookingdates.put("checkin","2016-07-28");
        bookingdates.put("checkout","2020-03-26");


        HashMap<String ,Object> expectedData=new HashMap<String, Object>();
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",716);
        expectedData.put("depositpaid",false);
        expectedData.put("bookingdates",bookingdates);

        return expectedData;

        }


        public JSONObject setUpTestAndRequestData(){

            JSONObject bookingdates=new JSONObject();
            bookingdates.put("checkin","2021-01-05");
            bookingdates.put("checkout","2021-01-10");

            JSONObject expectedRequest =new JSONObject();
            expectedRequest.put("firstname","Batch30");
            expectedRequest.put("lastname","bitti");
            expectedRequest.put("totalprice",123);
            expectedRequest.put("depositpaid",false);
            expectedRequest.put("bookingdates",bookingdates);
            return expectedRequest;






        }


}
