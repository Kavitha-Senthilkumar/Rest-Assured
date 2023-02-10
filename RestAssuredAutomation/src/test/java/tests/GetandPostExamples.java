package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.groovy.parser.antlr4.GroovyParser.MapPrmrAltContext;
import org.json.simple.JSONObject;


public class GetandPostExamples {
	@Test
public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given()
		.get("users?page=2")
		.then()
		.statusCode(200)
		.body("data[3].first_name",equalTo("Byron"))
		.body("data.first_name",hasItems("George","Rachel"));
		
}
	@Test
	public void testPost() {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("name","Kavitha");
//		map.put("job", "AutomationTester");
	//	System.out.println(map);
		JSONObject request =new JSONObject();
		request.put("name","Kavitha");
		request.put("job", "AutomationTester");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given()
		.header("ContentType","application")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		 .body(request.toJSONString())
		.when()
		 .post("/users")
		.then()
		 .statusCode(201)
		 .log().all();
		
		
	}
	

}
