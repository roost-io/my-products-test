# ********RoostGPT********

# Test generated by RoostGPT for test roost-io-my-products-api using AI Type  and AI Model 
# 
# Feature file generated for /products/{productId}_put for http method type PUT 
# RoostTestHash=7b2a6b6959
# 
# 

# ********RoostGPT********
Feature: Products API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']
    * configure headers = { Authorization: '#(authToken)' }

  Scenario Outline: Updating a product in the store with valid input payload
    Given path 'products', '<productId>'
    And request
      """
      {
        "id": "<id>",
        "name": "<name>",
        "description": "<description>",
        "price": "<price>"
      }
      """
    When method put
    Then status 200
    And match response ==
      """
      {
        "id": '#number',
        "name": '#string',
        "description": '#string',
        "price": '#number'
      }
      """
    And match response.id == '#(<id>)'
    And match response.name == '<name>'
    And match response.description == '<description>'
    And match response.price == '#(<price>)'

    Examples:
      | read('products_productId_put.csv') |