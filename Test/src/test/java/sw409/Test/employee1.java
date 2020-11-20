package sw409.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class employee1{
	
	@Test
	void getUser() {
		RestAssured.baseURI="http://localhost:8080/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/employees");
		String res = response.getBody().asString();
		System.out.println("Response is "+ res);
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	@Test
	void addUser(){
		RestAssured.baseURI= "http://localhost:8080/api/v1" ;
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.POST,"/employees");
		String res = response.getBody().asString();
		System.out.println("Response is " + res);
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 415);
		
	}
	@Test
	void updateUser() {
		RestAssured.baseURI= "http://localhost:8080/api/v1" ;
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.PUT,"/employees");
		String res = response.getBody().asString();
		System.out.println("Response is" + res);
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 405);
	}
	@Test
	void deleteUser() {
		RestAssured.baseURI ="http://localhost:8080/api/v1" ;
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.DELETE,"/employees");
		String res = response.getBody().asString();
		System.out.println("Response is" + res);
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 405);
	}
}

