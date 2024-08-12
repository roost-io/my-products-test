# ********RoostGPT********

# Test generated by RoostGPT for test API_Karate_DB_DBRX using AI Type DBRX and AI Model undefined
# 
# Feature file generated for /products/{productId}_get for http method type GET 
# RoostTestHash=ab8efa24ed
# 
# 

# ********RoostGPT********
---ROOST FEATURES START---

Feature: Testing Product API

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
  * url urlBase
  * configure headers = {'Content-Type': 'application/json'}

Scenario Outline: Testing Get Product By ID
  Given path '/products/<productId>'
  When method get
  Then status 200
  And response == 'object'
  And response.id == #present
  And response.name == '#string'
  And response.description == '#string'
  And response.price == '#number'
  * print 'response:', response

  Examples:
    | productId |
    |        10 |
    | '4'       |

Scenario Outline: Testing Post Product By ID
  Given path '/products/<productId>'
  When method post
  Then status 200
  And response == 'object'
  And response.id == #present
  And response.name == '<name>'
  And response.description == '<description>'
  And response.price == <price>
  * print 'response:', response

  Examples:
    | productId | name     | description                  | price |
    |        10 | 'apple'  | 'description of the product' |    20 |
    |        10 | 'banana' | 'description of the banana'  |    50 |

Scenario Outline: Testing Put Product By ID
  Given path '/products/<productId>'
  And request
    """
    {
      "name": "<name>",
      "description": "<description>",
      "price": <price>
    }
    """
  When method put
  Then status 200
  And response == 'object'
  And response.id == #present
  And response.name == '<name>'
  And response.description == '<description>'
  And response.price == <price>
  * print 'response:', response

  Examples:
    | productId | name     | description                  | price |
    |        10 | 'apple'  | 'description of the product' |    20 |
    |        10 | 'banana' | 'description of the banana'  |    50 |

Scenario: Testing Delete Product By ID
  Given path '/products/10'
  When method delete
  Then status 200
  And response == null

Scenario: Testing Product Not Found
  Given path '/products/-1'
  When method get
  Then status 404
  And response contains {error: 'Product not found'}

---ROOST FEATURES END---
