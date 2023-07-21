package restAssuredDay1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class HTTPRequest {

	 String user = "roshan.kohali@1secmail.com";
	String pass = "Virat@18#";

	@Test
	public void getRequest() throws IOException {

		given().auth().basic(user, pass).
//		header("Content-Type","application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).when()
				.get("https://ruralpro.agilecrm.com/dev/api/contacts/4599964190965760").then().log().all();
	}

	@Test
	public void postRequest() throws IOException {

		Path requestPayload = Paths.get("API//star_value.json");
		byte[] fileInByte = Files.readAllBytes(requestPayload);
		String fileinS = new String(fileInByte);
		JSONObject jsFile = new JSONObject(fileinS);
		JSONArray jsonArrayObj = jsFile.getJSONArray("properties");

		JSONObject js2 = jsonArrayObj.getJSONObject(2);
		String email = "bablu" + RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
		js2.put("value", email);
		JSONObject js3 = jsonArrayObj.getJSONObject(0);
		js3.put("value", "Mohan");

		 given().auth().basic(user, pass).
//		header("Content-Type","application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).
//				body(new FileInputStream("API\\star_value.json")).
				body(jsFile.toString()).when().post("https://ruralpro.agilecrm.com/dev/api/contacts").then().log()
				.all();

	}

	@Test
	public void putRequest() throws IOException {
		Path requestPayload = Paths.get("API//star_value.json");
		byte[] fileInByte = Files.readAllBytes(requestPayload);
		String fileinS = new String(fileInByte);
		JSONObject jsFile = new JSONObject(fileinS);
		JSONArray jsonArrayObj = jsFile.getJSONArray("properties");
//	    
		JSONObject js2 = jsonArrayObj.getJSONObject(2);
		String email = "bablu" + RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
		js2.put("value", email);
		JSONObject js3 = new JSONObject();
		js3.put("value", "Mohan");

		given().auth().basic(user, pass).
//		header("Content-Type","application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).
//				body(new FileInputStream("API\\star_value.json")).
				body(js3.toString()).when().post("https://ruralpro.agilecrm.com/dev/api/contacts/4591910456197120")
				.then().log().all();
	}
}
