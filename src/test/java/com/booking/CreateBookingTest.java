package com.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTest {

    @Test
    public void createBooking(){


        JSONObject body=new JSONObject();
        body.put("firstname","mosu");
        body.put("lastname","Mosuyev");
        body.put("totalprice",100);
        body.put("depositpaid",false);

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2025-01-01");
        bookingdates.put("checkout","2026-01-01");
        body.put("bookingdates",bookingdates);

        body.put("additionalneeds","obed");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();
        response
                .then()
                .statusCode(200);
        String name=response.jsonPath().getJsonObject("booking.firstname");
        String surname=response.jsonPath().getJsonObject("booking.lastname");
        Assertions.assertEquals("mosu",name);
        Assertions.assertEquals("Mosuyev",surname);
    }
}

