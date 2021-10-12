package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {

	// Base url
	final static String BaseUri = "https://petstore.swagger.io/v2/pet";

	@Test(priority = 1)
	public void addNewPet() {
		// create json request
		String reqBody = "{\n" + "  \"id\": 17232,\n" + "  \"name\": \"Riley\",\n" + "  \"status\": \"alive\"\n" + "}";

		Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(BaseUri);
		// assertion
		response.then().body("id", equalTo(17232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}

	@Test(priority = 2)
	public void getNewPet() {
		Response response = given().contentType(ContentType.JSON).when().pathParam("petId", "17232")
				.get(BaseUri + "/{petId}");

		System.out.println(response.asString());

		// assertion
		response.then().body("id", equalTo(17232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}

	@Test(priority = 3)
	public void deleteNewPet() {
		Response response = given().contentType(ContentType.JSON).when().pathParam("petId", 17232)
				.delete(BaseUri + "/{petId}");

		// asertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("17232"));
	}

}

