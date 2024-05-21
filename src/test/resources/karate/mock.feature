Feature: Mock API for Greeting

  Scenario: Compare actual API response with mocked data
    * def expectedResponse = read('classpath:karate/greeting.json')
    Given url 'http://localhost:8080'
    And path 'greeting'
    When method get
    Then status 200
    And match response == expectedResponse
