Feature: ValidationTestForLogin

  @phase1
  Scenario: Test Validation for invalid UserName with correct format
    When open Homepage
    Then user should see the home page title "NDTV: Latest News, India News, Breaking News, Business, Bollywood, Cricket, Videos & Photos"
    When user click on "Weather" option from header menu
    Then user should see the weather page title "NDTV Weather - Weather in your Indian City"
    When user search for "Ahmedabad" in Pin your city search
    Then user should see the "Ahmedabad" Pin your city search result
    When user select "Ahmedabad" from Pin your city search result
    Then user should see the "Ahmedabad" city in map
    When user click on the "Ahmedabad" city in map
    Then user should see the popup of "Ahmedabad" detail in the map










