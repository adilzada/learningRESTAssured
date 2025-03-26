package com.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBookingTest(){

        Response response=createBooking();

        String name=response.jsonPath().getJsonObject("booking.firstname");
        String surname=response.jsonPath().getJsonObject("booking.lastname");
        Assertions.assertEquals("mosu",name);
        Assertions.assertEquals("Mosuyev",surname);
    }
}

