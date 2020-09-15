Feature: ValidationForCityWeather

  @UIOnly
  Scenario: Test Validation for City Weather flow
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

  @APIAndUI
  Scenario: Validate the City Current temperature data from API and UI
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
    When user store the data for city "Ahmedabad" for UI
    When user get the data for endpoint "data/2.5/weather" with pathParam
      | q     | Ahmedabad                        |
      | appid | 7fe67bf08c80ded756e598d6f8fedaea |
      | units | metric                           |
    Then validate the status code should be "200"
    When user store the data for the city "Ahmedabad" from api
    Then compare the temperature data for UI and API in "C" and validate that both should be nealy same with variance less than "5"


  @APIAndUI
  Scenario: Validate the City Humidity data from API and UI
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
    When user store the data for city "Ahmedabad" for UI
    When user get the data for endpoint "data/2.5/weather" with pathParam
      | q     | Ahmedabad                        |
      | appid | 7fe67bf08c80ded756e598d6f8fedaea |
    Then validate the status code should be "200"
    When user store the data for the city "Ahmedabad" from api
    Then compare the humidity data for UI and API and validate that both should be nealy same with variance less than "5"








