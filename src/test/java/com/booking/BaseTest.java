package com.booking;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static java.util.Arrays.*;

public class BaseTest {
RequestSpecification spec;
    public void setup(){
        spec=new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com/")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();

    }



int bookingID=getID();
    protected int getID() {
        Response response = createBooking();
        // ID-nin cavabdan alınması
        return response.jsonPath().getJsonObject("bookingid");
    }

    protected Response createBooking() {

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(bookingObj("mosu","mosuyev",200))
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();
        response
                .then()
                .statusCode(200);
        return response;
    }
    protected String bookingObj(String firstname, String lastname, int totalPrice){
        JSONObject body=new JSONObject();
        body.put("firstname",firstname);
        body.put("lastname",lastname);
        body.put("totalprice",totalPrice);
        body.put("depositpaid",false);

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2025-01-01");
        bookingdates.put("checkout","2026-01-01");
        body.put("bookingdates",bookingdates);

        body.put("additionalneeds","obed");
        return body.toString();


    }
    String token=createToken();
    protected String createToken(){
        JSONObject body=new JSONObject();
        body.put("username","admin");
        body.put("password","password123");

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString())
                .log().all()
                .post("https://restful-booker.herokuapp.com/auth");

        response.prettyPrint();

        return response.jsonPath().getJsonObject("token");
    }

}
