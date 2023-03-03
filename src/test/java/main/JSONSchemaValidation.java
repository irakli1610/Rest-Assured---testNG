package main;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidation {

	@Test
	public void JsonSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/employees")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema-employees.json"));
			
		;
	}
	
}
