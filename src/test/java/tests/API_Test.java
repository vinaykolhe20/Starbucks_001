package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API_Test {

	
	
	@Test
	 public void testGetSinglePost() {
	        given()
	            .baseUri("https://jsonplaceholder.typicode.com")
	        .when()
	            .get("/posts/1")
	        .then()
	            .statusCode(200)
	            .body("userId", equalTo(1))
	            .body("id", equalTo(1));
	    }
	
	@Test
	 public void testGetTitle() {
	        given()
	            .baseUri("https://jsonplaceholder.typicode.com")
	        .when()
	            .get("/posts/1")
	        .then()
	            .statusCode(200)
	            .body("title", notNullValue())
	            .body("userId", equalTo(1))
	            .body("id", equalTo(1));
	    }
	
	
}
