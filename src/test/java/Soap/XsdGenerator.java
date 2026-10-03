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

public class XsdGenerator {

@Test

public void schemaValidation() throws IOException {
	
baseURI="http://www.dneonline.com/";


File file =new File(".\\SoapRequest\\Add.xml.txt");

if(file.exists())
	System.out.println("  >> File Exists");

FileInputStream fileInputStream = new FileInputStream(file);
String requestBody=IOUtils.toString(fileInputStream, "UTF-8");

given().contentType("text/xml").accept(ContentType.XML).body(requestBody).when().post("/calculator.asmx").then().statusCode(200).log().all().and()
.body("//*:AddResult.text()",equalTo("5")).and().assertThat().body(matchesXsdInClasspath("Calculator.Xsd.txt"));


}
}

// build path --->configure build path --> source ---><--- add text file inside the desktop & drag to the eclipse or pull file from target folder
// project -->build -->clean ( to remove the file in resource) 
// Project-->Build Project ---> updated file should add to resource / sync to resource
//to generate the response or data to get soap xml request 
//using free formatter converters >>XSD Generator >> get the soap api request 


