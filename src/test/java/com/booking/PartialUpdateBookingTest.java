package com.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingTest extends BaseTest{

    @Test
    public void partialUpdateBookingTest(){

        JSONObject patchbody=new JSONObject();
        patchbody.put("lastname","eliyev");
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                        .body(patchbody.toString())
                                .patch("https://restful-booker.herokuapp.com/booking/"+bookingID);


        response.prettyPrint();
        Assertions.assertEquals("mosu",response.jsonPath().getJsonObject("firstname"));
        Assertions.assertEquals("eliyev",response.jsonPath().getJsonObject("lastname"));

    }
}


//c