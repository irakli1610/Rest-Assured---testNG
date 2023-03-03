package main;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class PostRequestMethods {

	//hashmapp
	
	//@Test(priority=1)
	public void createUser() {
		
		String coursesArr[] = {"C","python"};
		
		HashMap map = new HashMap();
		map.put("name", "Berg");
		map.put("location", "Germany");
		map.put("phone", "5599716489");
		map.put("courses", coursesArr);

		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("http://localhost:3000/users")
		.then()
			.statusCode(201)
			.body("name", equalTo("Berg"))
			.body("location", equalTo("Germany"))
			.body("phone", equalTo("5599716489"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("python"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all()
			;
	}
	int id = 5;	
	
	//@Test(priority=2)
	public void deleteUser() {
		given()
		
		.when()
			.delete("http://localhost:3000/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	// using org.json library
	
	//@Test(priority=3)
	public void createUser2() {
		String coursesArr[] = {"JSON-C","JSON-python"};

		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "JSONBerg");
		jsonData.put("location", "JSONGermany");
		jsonData.put("phone", "JSON5599716489");
		jsonData.put("courses", coursesArr);
		given()
			.contentType("application/json")
			.body(jsonData.toString())
		.when()
			.post("http://localhost:3000/users")
		.then()
			.statusCode(201)
			.body("name", equalTo("JSONBerg"))
			.body("location", equalTo("JSONGermany"))
			.body("phone", equalTo("JSON5599716489"))
			.body("courses[0]", equalTo("JSON-C"))
			.body("courses[1]", equalTo("JSON-python"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all()
			;
	}
	
	//@Test(priority=4)
	public void deleteUser2() {
		given()
		
		.when()
			.delete("http://localhost:3000/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	//using POJO(Plain Old Java Object)
	//@Test(priority=5)
		public void createUser3() {
			
		String coursesArr[] = {"C","python"};

		
		POJO_PostRequest pojo = new POJO_PostRequest();
		pojo.setName("JSONBerg");
		pojo.setLocation("JSONGermany");
		pojo.setPhone("JSON5599716489");
		pojo.setCourses(coursesArr);
			
			
			given()
				.contentType("application/json")
				.body(pojo)
			.when()
				.post("http://localhost:3000/users")
			.then()
				.statusCode(201)
				.body("name", equalTo("JSONBerg"))
				.body("location", equalTo("JSONGermany"))
				.body("phone", equalTo("JSON5599716489"))
				.body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("python"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all()
				;
		}
		
		//@Test(priority=6)
		public void deleteUser3() {
			given()
			
			.when()
				.delete("http://localhost:3000/users/"+id)
			.then()
				.statusCode(200)
				.log().all();
		}
	
	
	// using external json file
		//@Test(priority=7)
		public void createUser4() throws FileNotFoundException {
			
		File file = new File("src/test/resources/body_post.json");
		FileReader fileReader = new FileReader(file);	
		JSONTokener jtokener = new JSONTokener(fileReader);
		JSONObject data = new JSONObject(jtokener);	
			given()
				.contentType("application/json")
				.body(data.toString())
			.when()
				.post("http://localhost:3000/users")
			.then()
				.statusCode(201)
				.body("name", equalTo("Berg"))
				.body("location", equalTo("Germany"))
				.body("phone", equalTo("89465132"))
				.body("courses[0]", equalTo("rust"))
				.body("courses[1]", equalTo("kotlin"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all()
				;
		}
		
		//@Test(priority=8)
		public void deleteUser4() {
			given()
			
			.when()
				.delete("http://localhost:3000/users/"+id)
			.then()
				.statusCode(200)
				.log().all();
		}
	
}
