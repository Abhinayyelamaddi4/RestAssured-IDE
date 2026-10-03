package tests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestsOnLocalAPI {
	
	// install nodeJS , execute commands --> notepad db.json ---> file is created(add data) , execute for host --->json-server --watch db.json
	// http://localhost:3000  ------> rest api created and hosted in local server
	// http://localhost:3000/users/007 ---> for id
	// http://localhost:3000/users?username=abhinay ---> for users subject
	
	/*
	 // add the new resource in the server
	   {
	     "users": 
	[
	    {
	        "username" : "abhinay",
	        "job" : "ethical hacker",
	        "id" : "007"
	    }
	]
	    } 
	 */
	
@Test

public void get() {
	
	baseURI ="https://localhost:3000";
	
	given().get("/users").then().statusCode(200).log().all();	
}

	
@Test

public void post() {
	
	
	JSONObject request =new JSONObject();
	
	request.put("firstName","rudra");
	request.put("LastName","ravindran");
	request.put("Id","1");
	
	System.out.println(request.toJSONString());
	
	baseURI ="https://localhost:3000"; 
	
	given().header("ContentType","Application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
	.when().post("/users").then().statusCode(201);
}


@Test

public void put() {
	
JSONObject request =new JSONObject();
	
	request.put("firstName","Ragu");
	request.put("LastName","Palu");
	request.put("Id","2");
	
	System.out.println(request.toJSONString());
	
	baseURI ="https://localhost:3000";
	
	given().header("ContentType","Application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
	.when().put("/users/4").then().statusCode(200);
	
}


@Test

public void patch() {
	

JSONObject request =new JSONObject();

request.put("firstName","Ravi");


System.out.println(request.toJSONString());

baseURI ="https://localhost:3000";

 given().header("ContentType","Application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
 .when().patch("/users/4").then().statusCode(200);
}


@Test
public void Delete() {
	
	baseURI ="https://localhost:3000";
	
	when().delete("/users/4").then().statusCode(200);
	
}

}


