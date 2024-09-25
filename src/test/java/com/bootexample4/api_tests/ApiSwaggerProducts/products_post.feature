
// ********RoostGPT********
/*

# Test generated by RoostGPT for test roost-io-my-products-api using AI Type  and AI Model 
# 
# Feature file generated for /products_post for http method type POST 
# RoostTestHash=dcd186097b
# 
# 

roost_feedback [9/25/2024, 2:20:57 PM]:- Add more comments to the test
*/

// ********RoostGPT********

Feature: Add a new product to the store

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * configure headers = { Authorization: #(karate.properties['AUTH_TOKEN']) }

  Scenario Outline: Test adding a new product
    Given path '/products'
    And request
      """
      {
        "id": <id>,
        "name": "<name>",
        "description": "<description>",
        "price": <price>
      }
      """
    When method post
    Then status 200
    * def responseId = response.id
    * def responseName = response.name
    * def responseDescription = response.description
    * def responsePrice = response.price
    And match response ==
      """
      {
        "id": '#integer',
        "name": '#string',
        "description": '#string',
        "price": '#integer'
      }
      """
    And assert responseId == <id>
    And assert responseName == '<name>'
    And assert responseDescription == '<description>'
    And assert responsePrice == <price>

    Examples:
      | read('products_post.csv') |
