package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
//needs to be reviewed, something not working
	//@Test
	public class ParsingJsonResponse {
	
	
	public void testJsonResponse() {
		
		//approach 1
		
		
//		given()
//			.contentType("ContentType.JSON")
//		.when()
//			.get("http://localhost:3000/employees")
//		.then()
//			.statusCode(200)
//			.body("name[2]", equalTo("Smith"))
//		;
		
		//approach 2
		
		
		Response response =
		given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/employees")
		;
		
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.header("Content-Type"),
				"application/json; charset=utf-8");
		String name =response.jsonPath().get("name[2]").toString();
		Assert.assertEquals(name, "Smith");
	}
	
	@Test
	public void testJsonResponseBodyData() {
		
		
		
		Response response =
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/employees")
		;
		
//		Assert.assertEquals(response.getStatusCode(),200);
//		Assert.assertEquals(response.header("Content-Type"),
//				"application/json; charset=utf-8");
//		String name =response.jsonPath().get("name[2]").toString();
//		Assert.assertEquals(name, "Smith");
		
		JSONObject jobj = new JSONObject(response.toString());
//		for (int i=0;i<jobj.getJSONArray("employees").length();i++) {
//			String age =jobj.getJSONArray("employees").getJSONObject(i).get("age").toString();
//			System.out.println(age);
//		}
	
	}
}
