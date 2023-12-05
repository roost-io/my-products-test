/*
Test generated by RoostGPT for test products-integration-rest-assured using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: null,
  rule: null,
  scenario: 'Create a new product\r\n' +
    '    Given the client provides the following product data:\r\n' +
    '      | name        | description              | price |\r\n' +
    '      | Test Product | This is a test product. | 10.0  |\r\n' +
    '    When the client sends a POST request to "/api/products"\r\n' +
    '    Then the saved product should not be null and its properties must correspond to those provided by client',
  title: 'Create a new product'
}

*/
package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class createANewProductTest {
    private static final String ROOST_SERVER_URL = System.getenv("ROOST_SERVER_URL");

    @Test
    public void createANewProductTest() {

        //Define Payload
        String payload ="{" +
                "\"name\":\"Test Product\"," +
                "\"description\":\"This is a test product.\"," +
                "\"price\":10.0" +
                "}";

        //Define Headers
        String headers ="{" +
                "\"Content-Type\":\"application/json\"," +
                "\"Accept\":\"application/json\"" +
                "}";

        // Post Product
        Response response = 
            given().
                contentType(ContentType.JSON).
                body(payload).
                when().
                post(ROOST_SERVER_URL + "/products").
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().
                response();

        // Asserts that the saved product is not null and its properties match those provided by the client
        assertNotNull(response.path("id"));
        response.then().body("name", equalTo("Test Product"));
        response.then().body("description", equalTo("This is a test product."));
        response.then().body("price", equalTo(10.0f));
        
    }
}
