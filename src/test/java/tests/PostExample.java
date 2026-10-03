package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class PostExample {

@Test

public void testPost() {
		
	Map<String, Object>map= new HashMap<String, Object>();
		
	// map is a connection for k & V --->k =key is always string  & v= value as object
		
		// map.put("name","raghav");
		// map.put("job", "teacher");
		// System.out.println(map);
		
		JSONObject request= new JSONObject(); // JSON simple dependencies are added in pom.xml --->convert request to JSON data format {} 
		
		request.put ("name","abhi");  
		request.put ("job","teacher");
		System.out.println(request.toJSONString());
		
		 baseURI="https://reqres.in/api";
		 
		 // content type and response type should be in JSON , header to post request  
		 
	    given().header("Content-Type","Application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().
	    post("/users").then().statusCode(201).log().all();
		
	   //given header() content type() accept()  body(request.toJSONString() when() (post) then() status() log() all() -post 
	    
	}	
}

