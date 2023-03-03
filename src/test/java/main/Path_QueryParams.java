package main;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Path_QueryParams {

	@Test
	public void testQueryAndPathParams() {
		
		given()
			.pathParam("userspath", "users")
			.queryParam("page",2)
			.queryParam("id", 5)
		.when()
			.get("https://reqres.in/api/{userspath}")
		.then()
			.statusCode(200)
			.log().all()
		;
	}
	
}
