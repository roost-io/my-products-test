# ********RoostGPT********

# Test generated by RoostGPT for test roost-io-my-products-api using AI Type  and AI Model 
# 
# Feature file generated for /products/{productId}_delete for http method type DELETE 
# RoostTestHash=befb82c928
# 
# 

# ********RoostGPT********
Feature: Delete a product

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase
    * configure headers = { Authorization: #(karate.properties['AUTH_TOKEN']) }

  Scenario Outline: Delete a product with valid product ID
    Given path 'products', '<productId>'
    When method delete
    Then status 200
    And match response == 'string'

    Examples:
      | read('products_productId_delete.csv') |

  Scenario Outline: Delete a product with non-existing product ID
    Given path 'products', '<productId>'
    When method delete
    Then status 404
    And match response == 'string'

    Examples:
      | productId |
      |       100 |
      |       200 |
      |       300 |
