package apiTesting;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI= "https://rahulshettyacademy.com";
        //RestAssured will work on 3 principles - Given, when and then.
        given().log().all().queryParam("key","qaclick123").contentType("application/json").body(Payloads.Add_Place()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("status",equalTo("OK")).log().all();
    }
}
