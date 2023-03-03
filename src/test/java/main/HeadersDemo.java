package main;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class HeadersDemo {

	//@Test  
	public void testHeaders() {
		given()
	
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			;
	}
	
	
	//@Test
	public void getHeadersInfo() {
		
		Response response=given()
	
		.when()
			.get("https://www.google.com/")
		;
		//get single headers info
		String header_value =response.getHeader("Content-Type");
		System.out.println("header======"+header_value);
	
		//get all headers info
		Headers headers = response.getHeaders();
		
		
		for (Header header : headers) {
			System.out.println("go ----=="+header.getName()+" ===="
					+header.getValue());
		}
		
	}
	
	
	//@Test
	public void loggong() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
		//.log().body()
		//.log().all()
		//.log().cookies()
		//.log().headers()
		;
	}
	
}
