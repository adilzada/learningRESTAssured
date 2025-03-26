package com.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected int getID() {
        Response response = createBooking();
        // ID-nin cavabdan alınması
        return response.jsonPath().getJsonObject("bookingid");
    }

    protected Response createBooking() {

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(bookingObj())
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();
        response
                .then()
                .statusCode(200);
        return response;
    }
    protected String bookingObj(){
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
        return body.toString();


    }

}
