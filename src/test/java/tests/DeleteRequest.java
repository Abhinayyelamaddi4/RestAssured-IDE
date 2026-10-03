package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteRequest {
			
@Test

public void testDelete() {
	
	baseURI="https://reqres.in";
	
	when().delete("/api/users/2").then().statusCode(204).log().all();
	
	////--when() delete() then() status() log() all() --delete
		
}
}