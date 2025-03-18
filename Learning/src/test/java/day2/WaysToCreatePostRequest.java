package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import io.restassured.internal.support.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

/*
	1> using hashmap.
	2> creation using Org.json.
	3> creation using POJO class.
	4> using external json file data.
 */

public class WaysToCreatePostRequest {
	
//	1>
	
//	@Test
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "98765");
		
		String courseArr[] = {"c","c++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"));
		
	}
	
//	2>
	
	@Test
	void testPostUsingJson() {
		
		JSONObject data = new JSONObject();
		
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "98765");
		
		String courseArr[] = {"c","c++"};
		data.put("courses", courseArr);
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"));
		
	}
	
	
//	3> using POJO (here we use the concept of data encapsulation 
	
	@Test
	void testPostUsingPOJO() {
		
		POJO_PostRequest data = new POJO_PostRequest();
		
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("12345");
		String courseArr[] = {"c","c++"};
		data.setCourses(courseArr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"));
		
	}
	
//	4> using external json file 
	
	@Test
	void testPostUsingExternal() {
		
		File f = new File("..\\body.json");
		
		FileReader fr = new FileReader();
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"));
		
	}

}
