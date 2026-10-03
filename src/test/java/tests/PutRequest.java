package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;  //retrieving from jsonsimple dependency
import org.testng.annotations.Test; // retrieving from testng dependency

import io.restassured.http.ContentType;

@Test

public class PutRequest {
	
	public void testPut() {
		
		Map<String,Object>map =new HashMap<String,Object>();
		
	    //map.put("name","morpheus");
		//map.put("job","teacher");
		//System.out.println(map);
		
		JSONObject request =new JSONObject();
		request.put("name","morpheus");
		request.put("job","zion resident");
		System.out.println(request.toJSONString());   // requesting in JSONString method
		
		 baseURI="https://reqres.in";
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when() 
		.put("/api/users/2").then().statusCode(200).log().all();
		
		// given header() content type() accept()body(request.toJSONString())  when() (put) then() status() log() all() -put	
		
	}
	}
	

