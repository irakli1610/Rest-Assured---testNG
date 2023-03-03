package main;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {

	@Test  //this test will fail
	public void testcookies() {
		given()
	
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC", "ARSKqsIyqbUSU_CaupFaffDPxEogBDR0YhGvuIgrcyMyswSgCNXOIkBEhQ; expires=Wed, 23-Aug-2023 08:15:37 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax")
			.log().all()
		;
	}
	
	@Test
	public void getCookiesInfo() {
		Response response=given()
	
		.when()
			.get("https://www.google.com/")
		;
		//get single cookie info
		String cookie_value =response.getCookie("AEC");
		System.out.println(cookie_value);
	
		//get all cookies info
		Map<String, String> cookies =response.getCookies();
		
		
		for (String cookie : cookies.keySet()) {
			String multcookie_value = response.getCookie(cookie);
			System.out.println("go ----------cookie ======"+multcookie_value);
		}
		
	}
	

	
}
