package day3;

import org.testng.annotations.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class HeadersDemo {
	
	@Test
	void testCookie() {
		given() 
		
		.when()
			.get("https://www.google.com")
		
		.then()
			.cookie("AEC","AVcja2e4Pmbi-Mws0XIjVOeJWVHUGwTHXvVGBWZj3utkeMwOcZZs2oVkUzE")
			.log().all();

	}
}

