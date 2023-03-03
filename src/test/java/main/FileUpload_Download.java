package main;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUpload_Download {

	//@Test
	public void singleFileUpload() {
		File file = new File("C:\\Users\\irakl\\Desktop\\postman-Rest docs\\a.txt");

		
		given()
			.multiPart("file",file)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
		;
	}
	
	
	@Test
	public void singleFileDownload() {

		
		given()
		.when()
			.get("http://localhost:8080/downloadFile/a.txt")
		.then()
			.statusCode(200)
		;
	}
	
}
