package chain.copy;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class ChainingCreateUser {

	@Test
	public void createUser(ITestContext context) {
		String bearertoken = "502c2347030aa8820aeb413cc45f99ad25946cdd0a1aeaca89b7f9ada77a2a12";
		
		
		Faker faker = new Faker();
		JSONObject jobj = new JSONObject();
		jobj.put("name", faker.name().fullName());
		jobj.put("gender", "Male");
		jobj.put("email", faker.internet().emailAddress());
		jobj.put("status", "inactive");
		
		int id =
		given()
			.headers("Authorization","Bearer "+bearertoken)
			.contentType("application/json")
			.body(jobj.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id")
		;
		System.out.println("------------------------create");
		context.setAttribute("user_id", id);
		
	}
	
	
}
