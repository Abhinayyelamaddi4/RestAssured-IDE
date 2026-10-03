package tests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

	public class GetRequest {
		
		          //given ---------- get() then() status() body()log() all() -get
	@Test
	public void testGet() {
		
	    baseURI="https://reqres.in/api";
		
	//	given().get("/users?page=2").then().statusCode(200).body("data[4].first_name",equalTo("George")).
	//	body("data.first_name",hasItems("George","Rachel"));
		
   //given().get("/users?page=2").then().statusCode(200).body("data[2].first_name",equalTo("Tobias"))
   //.body("data.first_name",hasItems("Tobias","Ferguson")).log().all();
	    
	    given().get("/users?page=2").then().statusCode(200).body("data[1].first_name",equalTo("Lindsay")).
		body("data.first_name",hasItems("Lindsay","Tobias"));

		
		
	}
}
