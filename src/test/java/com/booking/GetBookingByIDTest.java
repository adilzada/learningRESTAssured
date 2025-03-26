package com.booking;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIDTest extends BaseTest {

    @Test
    public void getBookingByIDTest(){


        Response response= given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/"+getID());

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        String firstname=response.jsonPath().getJsonObject("firstname");
        String lastname=response.jsonPath().getJsonObject("lastname");
        int totalprice=response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("mosu",firstname);
        Assertions.assertEquals(100,totalprice);
        Assertions.assertEquals("Mosuyev",lastname);



    }
}
//        given()
//                .when()
//                .and()
//                .get("https://restful-booker.herokuapp.com/booking/29")
//                .then()
//                .log().all()
//                .statusCode(200);