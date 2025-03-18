package day3;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class PathAndQueryParameter {
	
	@Test
	 void testQueryAndPathParameters() {
		
		
		given()
			.pathParam("mypath","users")
			.queryParam("page,2")
			.queryParam("id",5)
		
		.when() 
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
