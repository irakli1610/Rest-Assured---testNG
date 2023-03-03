package main;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGeneragor {

	@Test
	public void dummyGeneratorData() {
		Faker faker = new Faker();
		String first_name=faker.name().firstName();
		String last_name=faker.name().lastName();
		String username =faker.name().username();
		
		
	}
}
