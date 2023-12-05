/*
Test generated by RoostGPT for test products-integration-rest-assured using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: null,
  rule: null,
  scenario: 'Update an existing product\r\n' +
    '    Given there is an existing product with ID 1\r\n' +
    '    And the client provides the following product data:\r\n' +
    '      | name           | description                      | price |\r\n' +
    '      | Updated Product | This is an updated test product. | 15.0  |\r\n' +
    '    When the client sends a PUT request to "/api/products/1"\r\n' +
    '    Then the product with ID 1 should be updated with the provided details',
  title: 'Update an existing product'
}

*/
package com.bootexample4.RoostTest;

import static org.hamcrest.Matchers.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class updateAnExistingProductTest {

    @Before
    public void setup() {
        RestAssured.baseURI = System.getenv("ROOST_SERVER_URL");
    }

    @Test
    public void updateAnExistingProduct_SuccessScenario() {
        // Scenario - Update an existing product
        /*
        Given there is an existing product with ID 1
        And the client provides the following product data:
        | name           | description                      | price |
        | Updated Product | This is an updated test product. | 15.0  |
        When the client sends a PUT request to "/api/products/1"
        Then the product with ID 1 should be updated with the provided details
        */

        // Given there is an existing product with ID 1
        RestAssured.given()
                .pathParam("productId", 1)
                .when()
                .get("/products/{productId}")
                .then()
                .statusCode(200)
                .body("id", is(1));

        // And the client provides the following product data:
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "Updated Product");
        payload.put("description", "This is an updated test product.");
        payload.put("price", 15.0);

        // When the client sends a PUT request to "/api/products/1"
        RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("productId", 1)
                .body(payload)
                .when()
                .put("/products/{productId}")
                .then()

                // Then the product with ID 1 should be updated with the provided details
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Updated Product"))
                .body("description", is("This is an updated test product."))
                .body("price", is(15.0));
    }
}
