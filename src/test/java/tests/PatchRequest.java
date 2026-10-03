package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

	@Test
public class PatchRequest {
		
		public void testPatch() {
			Map<String,Object>map =new HashMap<String,Object>();
				
			JSONObject request =new JSONObject();
			request.put("name","abhi");
			request.put("job","zion resident");
			System.out.println(request.toJSONString());
			
			 baseURI="https://reqres.in";
			
			given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when() 
			.patch("/api/users/2").then().statusCode(200).log().all();
				
			
		//given header() content type() accept() body(request.toJSONString())  when() (patch) then() status() log() all() ---->patch	
			
		}
		}
		

