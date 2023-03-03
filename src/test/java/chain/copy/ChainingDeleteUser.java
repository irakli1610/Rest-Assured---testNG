package chain.copy;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ChainingDeleteUser {
	
	@Test
	public void deleteUser(ITestContext context) {
		String bearertoken = "502c2347030aa8820aeb413cc45f99ad25946cdd0a1aeaca89b7f9ada77a2a12";
		int id = (int)context.getAttribute("user_id");
		given()
			.headers("Authorization","Bearer "+bearertoken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
		;
		System.out.println("--------------------delete");

		
	}
	
	
}
