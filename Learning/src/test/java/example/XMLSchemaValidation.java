package example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class XMLSchemaValidation {

	@Test
	public void schemaValidation() throws IOException {

		baseURI = "http://www.dneonline.com";

		File file = new File("./SoapRequest/Add.xml");

		if (file.exists())
			System.out.println("  >>  File Exists");

		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

		baseURI = "http://www.dneonline.com";

		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody)
		
		.when()
			.post("/calculator.asmx").then()
			.statusCode(200)
			.log().all()
			.and()
			.body("//*:AddResult.text()", equalTo("5"))
			.and()
			.assertThat().body(matchesXsdInClasspath("Calculator.xsd"));
	}

}
