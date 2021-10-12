package com.github;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GithubRestAPI {

	// Declare request specification
	RequestSpecification requestSpec;
	// Declare response specification
	ResponseSpecification responseSpec;
	// Declare SSH key and sshId
	String sshKey;
	int sshId;
	String accessToken;

	@BeforeClass
	public void setup() {
		accessToken = "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";

		// Create request specification
		requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri("https://api.github.com").addHeader("Authorization", "Bearer " + accessToken).build();
	}

	@Test(priority = 1)
	public void postSSHkey() {
		String reqBody = "{\n" + "    \"title\": \"TestAPIKey\",\n"
				+ "    \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDWKC3G9wB8TU8Y9QQ8+Vtf5YedKtPVdlnHQiq3BIRze8zw3oRUbP0owr3ohUWEa+kMLhpHa20Plq/FxIf0iCA4oMI5XUhlPGMp+W31uUcg9S3yeTzk7YVgf56VdmbiTnP21Bga5Mf8pz/DTbR07TYRk00RdzeU6IlQz7yOkPih3E5n/kIvrwwZVJQfjZzt5qAz/1+jgx+Uec23Xz10FvwYJnBp6PFuzTCA3+qnQ9Rl+gu8ZCYBfyfaU+jJ1gZZpk2BNpB+QFzyuy7G3+m4TNxqMGGwcD0KCvBhYrVnLQ7fArdDZE2tJZQd5DPmmRxhTMHG+U1BF6FdnC+3mjcYT4rT6KrlNTUuiRlJ80dYGqqW2s3Yaz3bLY6aFK0x1hNjVTZaAjKsI1H6pXrsvIJUfULFQw+tH8qZzlBOyibLgAsulETtAwqt9B2oi9AQOeSJvzaEHXhYts3SL3VAgJtqhtlZlpui84unUniupsmltzQ2tBbdfSS1nuf39bzfCB6efrc=\"\n"
				+ "}";

		Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys");
		String res = response.asString();
		System.out.println("Post Method Response Body: " + res);
		JsonPath js = new JsonPath(res);
		sshId = js.get("id");
		// assertion
		System.out.println("Id value from response body is : " + sshId);
		response.then().statusCode(201);
	}

	@Test(priority = 2)
	public void getSSHkey() {
		Response response = given().spec(requestSpec).when().get("/user/keys");
		String res = response.asString();
		System.out.println("Get Method Response Body: " + res);

		// assertion
		response.then().statusCode(200);

	}

	@Test(priority = 3)
	public void deleteSSHkey() {
		Response response = given().spec(requestSpec).pathParam("keyId", sshId).when().delete("/user/keys/{keyId}");
		String res = response.asString();
		System.out.println("Delete Method Response Body: " + res);
		// assertion
		response.then().statusCode(204);
	}
}
