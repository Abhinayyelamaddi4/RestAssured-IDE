package tests;
// 1st
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Restapi {

@Test 	
// -->run configuration -->select testNG --->new --->test column <--> browse and select package & class---> run directly 
    public void test_1() {
	Response response=RestAssured.get("https://reqres.in/api/users?page=2");  
	// click on the API (GET method) --> find the page URL -->( URL is the RestApi request )
	
	System.out.println(response.getHeader("content_type"));
	System.out.println(response.getBody().asString());
	System.out.println(response.getTime());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	
	int statuscode = response.statusCode();
	Assert.assertEquals(statuscode,200);	
}


@Test
public void test_2() {
	
	baseURI="https://reqres.in/api";
	
	// given function is taken from rest assured library
	// using json path finder i can provide json response and get path of a particular element 
	
	given().get("/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8)).log().all();
		
}
	
}

