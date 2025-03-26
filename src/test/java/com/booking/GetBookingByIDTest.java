package com.booking;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIDTest {

    @Test
    public void getBookingByID(){

//        given()
//                .when()
//                .and()
//                .get("https://restful-booker.herokuapp.com/booking/29")
//                .then()
//                .log().all()
//                .statusCode(200);

        Response response= given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/742");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        String firstname=response.jsonPath().getJsonObject("firstname");
        String lastname=response.jsonPath().getJsonObject("lastname");
        int totalprice=response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("John",firstname);
        Assertions.assertEquals(111,totalprice);
        Assertions.assertEquals("Smith",lastname);



    }
}
