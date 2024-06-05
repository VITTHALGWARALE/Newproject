Feature: Search for flights on MakeMyTrip

  Scenario: Verify Search for flights from Delhi to Hyderabad on MakeMyTrip
  
    Given User is on MakeMyTrip homepage
    When User selects origin as "Delhi" and destination as "Hyderabad"
    And User selects today's date for departure
    And User triggers the search
    Then User should see the search results
    And User extracts flight details such as airline, departure time, arrival time, and price
    And User sorts the flight details by the lowest price
    And User displays the sorted flight details
