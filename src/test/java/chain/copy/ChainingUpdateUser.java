package chain.copy;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class ChainingUpdateUser {

	
	
	
	
	@Test
	public void updateUser(ITestContext context) {
		String bearertoken = "502c2347030aa8820aeb413cc45f99ad25946cdd0a1aeaca89b7f9ada77a2a12";
		
		
		Faker faker = new Faker();
		JSONObject jobj = new JSONObject();
		jobj.put("name", faker.name().fullName());
		jobj.put("gender", "Female");
		jobj.put("email", faker.internet().emailAddress());
		jobj.put("status", "active");
		
		int id = (int)context.getAttribute("user_id");
		
		
		given()
			.headers("Authorization","Bearer "+bearertoken)
			.contentType("application/json")
			.body(jobj.toString())
			.pathParam("id", id)
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
		;
		System.out.println("------------------update");

		
	}
	
	
	
}
