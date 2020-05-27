Feature:SbdbCloseApproachDataApi
  This feature deals with getting data for all asteroids and comets in JPL’s SBDB (Small-Body DataBase).

  Scenario: Get all close approach data for asteroid with valid query parameters
    Given I want to execute service "/cad.api"
    When I add query parameter key as "des" and value as "433"
    And I add query parameter key as "date-min" and value as "1900-01-01"
    And I add query parameter key as "date-max" and value as "2100-01-01"
    And I add query parameter key as "dist-max" and value as "0.2"
    And I submit the GET request
    Then I validate that response status code is 200
    And I validate response with json schema "cdaJsonSchema.json"
    And I validate that response contains total 5 records
    And I validate that response contains data with timestamp "1931-Jan-30 04:07"
    And I validate that response data with timestamp "1931-Jan-30 04:07" is present at position 0

  Scenario: Get 400 status code with invalid query parameter while getting close approach data for asteroid
    Given I want to execute service "/cad.api"
    When I add query parameter key as "des" and value as "0"
    And I add query parameter key as "date-min" and value as "1900-01-01"
    And I add query parameter key as "date-max" and value as "2100-01-01"
    And I add query parameter key as "dist-max" and value as "0.2"
    And I submit the GET request
    Then I validate that response status code is 400
    And I validate that response contains message as "specified object was not found"