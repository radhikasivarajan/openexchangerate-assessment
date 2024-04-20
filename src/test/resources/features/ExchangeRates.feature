@test
Feature: Exchange Rates API

  Scenario: ER API- USD
    When I hit the open ER API 'https://open.er-api.com/v6/latest/USD'
    Then a 200 status code is returned
    And the json schema is correct
    And the response field 'result' is 'success'
    And the response field 'base_code' is 'USD'
    And the AED rate is in the range '3.6' - '3.7'
    And the number of currency pairs returned is '162'

