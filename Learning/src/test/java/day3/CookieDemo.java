package day3;

import org.testng.annotations.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class CookieDemo {
	
//	@Test
	void testCookie() {
		given() 
		
		.when()
			.get("https://www.google.com")
		
		.then()
			.cookie("AEC","AVcja2e4Pmbi-Mws0XIjVOeJWVHUGwTHXvVGBWZj3utkeMwOcZZs2oVkUzE")
			.log().all();

	}
	
	@Test
	void getCookiesInfo() {
		
		Response res = given() 
				
					.when()
						.get("https://www.google.com");
		
		Map<String, String> cookies_values = res.getCookies();
		
		for(String k : cookies_values.keySet()) {
			String cookies_value = res.getCookie(k);
			System.out.println(k+"   "+cookies_value);
		}
		
		
	}

}
