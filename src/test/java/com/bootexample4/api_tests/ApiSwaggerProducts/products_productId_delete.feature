# ********RoostGPT********

# Test generated by RoostGPT for test API_Karate_DB_DBRX using AI Type  and AI Model 
# 
# Feature file generated for /products/{productId}_delete for http method type DELETE 
# RoostTestHash=befb82c928
# 
# 

# ********RoostGPT********
 Corrected configuration in code blocks:

---ROOST FEATURES START--- 

Feature: Delete a product

  Background:
    def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    url urlBase
    header Authorization = 'Bearer ' + karate.properties['AUTH_TOKEN']

  Scenario Outline: Delete a product with valid productId
    Given path '/products/<productId>'
    When method DELETE
    Then status 200

    Examples:
      | productId |
      |         4 |

  Scenario: Delete a product with invalid productId
    Given path '/products/-1'
    When method DELETE
    Then status 404

---ROOST FEATURES END---