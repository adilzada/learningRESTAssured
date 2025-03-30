package com.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends BaseTest {
    @Test
    public void deleteBookingTest(){

        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+bookingID);
        response
                .then()
                .statusCode(201);
        response.prettyPrint();

    }
}
