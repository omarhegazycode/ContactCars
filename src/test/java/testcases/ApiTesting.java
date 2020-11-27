/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    26/11/2020  - Script created.
 */
package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import utilities.Reporter;


/**

Assert on:
- Every node should have an "id"
- Every node should have a "name"
- Every node should have a “url”

 */
public class ApiTesting 
{
	@Test
	void APItest()
	{
		String APIURL = utilities.LoadProperties.userData.getProperty("APIURL");
		for (int i =0;i<8; i++)
		{
		     given()     
	                      .accept(ContentType.JSON)
	                      .param("children", "[i]")
	                      .when()
	                      .get(APIURL)
	                      .then()
	                      .assertThat()
	                      .statusCode(200)
	                      .and()
	                      .assertThat()
	                      .body("categoryId", not(empty()))
	                      .and()
	                      .assertThat()
	                      .body("name", not(empty()))
	                      .assertThat()
	                      .body("url", not(empty()))
	                      .log()
	                      .all();
	                      RequestSender httpRequest = RestAssured.given();  //Getting the Request
	                      Response response = httpRequest.get(APIURL);  //Getting the response
	                      Reporter.Log("Request " +"["+ httpRequest+"]");  //Print the request in the report 
	                      Reporter.Log("Response "+"["+response+"] ");   //Print the response in the report 
			}
		  given()     //Assert that Every node should have an “image” except 3rd level category
                .accept(ContentType.JSON)
                .param("level", "1")
                .param("level", "2")
                .when()
                .get(APIURL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("featureImage", not(empty()))
                .log()
                .all();
                RequestSender httpRequest = RestAssured.given();  //Getting the Request
                Response response = httpRequest.get(APIURL);  //Getting the response
                Reporter.Log("Request " +"["+ httpRequest+"]");  //Print the request in the report 
                Reporter.Log("Response "+"["+response+"] ");   //Print the response in the report 
		        Reporter.Log("### API test case passed successfully ###");
	}

}
