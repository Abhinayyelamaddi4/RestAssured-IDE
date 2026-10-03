package Soap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaValidator {

@Test
public void JSONSchemaValidator() {   // add dependencies from central maven repository -------> JSONSchemaValidator ,
	
	baseURI="https://reqres.in/api";  // follow below lines 
	given().get("/users?page=2").then().statusCode(200).assertThat().body(matchesJsonSchemaInClasspath("Schema.Json.txt"));
}


}


//add Json Schmea validator dependencies form maven central repository restassured
	// using json to json schemaconvertor (liquid tech website) 
	// target folder --->properties -->insert file resource from target folder<-->(or)<--> create file in target folder -->drag and drop directly