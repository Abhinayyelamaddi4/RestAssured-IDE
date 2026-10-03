package Soap;

import static io.restassured.RestAssured.baseURI; // // explicit outside items , implicits are hasItems , equalTo
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File; // to import file (external resource) add segement from java
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils; // add from extensions apache , testng, jsonsimple ,
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXMLRequest {

@Test

public void validateSoapXML() throws IOException {


//using wizdler extension we can use calculator soap options for api request 
//create text document in desktop( Add.xml) & add to folder in package explorer 
// apache commons dependencies are  added to pom.xml from maven central repository.

File file =new File(".\\SoapRequest\\Add.xml.txt");

if(file.exists())
	System.out.println("  >> File Exists");

FileInputStream fileInputStream = new FileInputStream(file);
String requestBody=IOUtils.toString(fileInputStream, "UTF-8");

baseURI ="http://www.dneonline.com";   // body is a pre-condition added to contenttype

given().contentType("text/xml").accept(ContentType.XML).body(requestBody).when().post("/calculator.asmx").then().statusCode(200).log().all().
body("//*:AddResult.text()", equalTo("5"));	


}
}

// to validate the data in response or value in response for the above Api request 
//using freeformatter validators >>xpath tester = //*:AddResult & //*:AddResult/text()

