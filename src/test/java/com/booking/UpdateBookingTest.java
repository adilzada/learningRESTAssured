package com.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends BaseTest{

    @Test
    public void updateBookingTest(){
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .body(bookingObj("ilkin","adil",300))
                .put("https://restful-booker.herokuapp.com/booking/"+bookingID);
        response.prettyPrint();


    }


}
