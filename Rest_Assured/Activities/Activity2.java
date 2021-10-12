package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {

	// Base url
	final static String BaseUri = "https://petstore.swagger.io/v2/user";

	@Test(priority = 1)
	public void addNewUser() throws IOException {

		//Input from json file
		FileInputStream inputJson = new FileInputStream("src/test/java/activities/reqBody.JSON");

		// Read json file as String
		String reqBody = new String(inputJson.readAllBytes());

		Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(BaseUri);

		inputJson.close();
		System.out.println(response.asString());

		// assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("9082"));
	}

	@Test(priority = 2)
	public void getNewUser() {
		//Import json file to write to
		File outputJSON = new File("src/test/java/activities/userResponse.json");

		Response response = given().contentType(ContentType.JSON).pathParam("username", "sanpat").when()
				.get(BaseUri + "/{username}");

		// get response body
		String resBody = response.asPrettyString();

		try {
			// Create JSON file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}

		System.out.println(response.asString());

		// assertion
		response.then().body("id", equalTo(9082));
		response.then().body("username", equalTo("sanpat"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
	}

	@Test(priority = 3)
	public void deleteUser() {
		Response response = given().contentType(ContentType.JSON).pathParam("username", "sanpat").when()
				.delete(BaseUri + "/{username}");

		System.out.println(response.asString());
		// asertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("sanpat"));

	}

}
