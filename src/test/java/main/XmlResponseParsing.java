package main;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;

public class XmlResponseParsing {
	
	//@Test
	public void xmlTest() {
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
			;
	}
	
	//@Test
		public void xmlTestmethod2() {
		
		Response response =
		given()
	
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"), "application/xml; charset=utf-8");
		
		String name =response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "Developer");
	}
		
		
		
		@Test
		public void xmlTestmethod3() {
			
			Response response =
			given()
			.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
			XmlPath xmlobj = new XmlPath(response.asString());
			
			//total bumber of travellers
			List<String> travellers =xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
			Assert.assertEquals(travellers.size(), 10);
			
			//verify presence of certain name in response
			List<String> travellersName =xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
			
			boolean namePresent = false;
			for (String name : travellersName) {
				if(name.equals("Developer12 3") ) {
					namePresent=true;
					break;
				}
			}
			Assert.assertEquals(namePresent, true);
			
		}
}
