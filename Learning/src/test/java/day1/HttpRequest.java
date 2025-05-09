package day1;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequest {
	
	int id = 0 ;
	
//	@Test(priority = 1)?
	void getUsers() {
		
		given()
	
		.when() 
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
	@Test(priority = 2)
	void createUser() {
		
		HashMap data = new HashMap() ;
		data.put("name", "arsh");
		data.put("job", "student");
		
		id = given()
			.contentType("application/json")
			.body(data)
		
		.when()	
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		System.out.println("here is your id:"+id);

	}
	
//	@Test(priority = 3,dependsOnMethods = {"createUser"} )
	void updateUser() {
		
		HashMap data = new HashMap() ;
		data.put("name", "raza");
		data.put("job", "student1");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()	
			.put("https://reqres.in/api/users"+id)
			
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
