package Soap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XMLSchemaValidation {

@Test

public void schemaValidation() throws IOException {
	
baseURI="http://www.dneonline.com/";

//using wizdler extension we can use calculator soap options for api request 
//create text document in desktop( Api request added toit ) and add it to folder in package explorer & drag and drop it to created folder 
// apache commons are added to pom.xml from maven central repository.

File file =new File(".\\SoapRequest\\Add.xml.txt");

if(file.exists())
	System.out.println("  >> File Exists");

FileInputStream fileInputStream = new FileInputStream(file);
String requestBody=IOUtils.toString(fileInputStream, "UTF-8");

given().contentType("text/xml").accept(ContentType.XML).body(requestBody).when().post("/calculator.asmx").then().statusCode(200).log().all().and()
.body("//*:AddResult.text()",equalTo("5")); // AddResult<5> -->result


}
} 

//to generate the response or data to get soap xml request 
//using freeformatter converters >>XSD Generator >> get the soap api request 


