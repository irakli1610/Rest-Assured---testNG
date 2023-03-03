package main;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SerializationDeserialization {
	
	// @Test(priority=1)
	public void convertPojoToJson() throws JsonProcessingException {
		String coursesArr[] = {"C","python"};

		POJO_PostRequest pojo = new POJO_PostRequest();
		pojo.setName("JSONBerg");
		pojo.setLocation("JSONGermany");
		pojo.setPhone("JSON5599716489");
		pojo.setCourses(coursesArr);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(jsonData);
		
	}
	
	@Test(priority=2)
	public void convertJsonToPojo() throws JsonMappingException, JsonProcessingException {
		
		String jsondata="{\r\n"
				+ "  \"name\" : \"JSONBerg\",\r\n"
				+ "  \"location\" : \"JSONGermany\",\r\n"
				+ "  \"phone\" : \"JSON5599716489\",\r\n"
				+ "  \"courses\" : [ \"C\", \"python\" ]\r\n"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		POJO_PostRequest seserializedpojo= mapper.readValue(jsondata,POJO_PostRequest.class);
		
		System.out.println(seserializedpojo.getLocation());
		System.out.println(seserializedpojo.getName());
		System.out.println(seserializedpojo.getPhone());
		System.out.println(seserializedpojo.getCourses()[0]);
		System.out.println(seserializedpojo.getCourses()[1]);
	
	}
}
