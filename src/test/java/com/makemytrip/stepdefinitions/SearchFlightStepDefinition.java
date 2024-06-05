package com.makemytrip.stepdefinitions;

import com.makemytrip.pageobjects.SearchFlightPageObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlightStepDefinition extends SearchFlightPageObject{

	@Given("User is on MakeMyTrip homepage")
	public void user_is_on_make_my_trip_homepage() throws InterruptedException {
		
		verify_HomePage();
	}

	@When("User selects origin as {string} and destination as {string}")
	public void user_selects_origin_as_and_destination_as(String origin, String destination) throws InterruptedException {
		
		enter_Origin_And_Destination_Input(origin, destination);
	}

	@And("User selects today's date for departure")
	public void user_selects_today_s_date_for_departure() throws InterruptedException {
		select_DepartureDate();
	}

	@And("User triggers the search")
	public void user_triggers_the_search() throws InterruptedException {
		click_On_Search();
	}

	@Then("User should see the search results")
	public void user_should_see_the_search_results() {

	}

	@And("User extracts flight details such as airline, departure time, arrival time, and price")
	public void user_extracts_flight_details_such_as_airline_departure_time_arrival_time_and_price() {

	}

	@And("User sorts the flight details by the lowest price")
	public void user_sorts_the_flight_details_by_the_lowest_price() {

	}

	@And("User displays the sorted flight details")
	public void user_displays_the_sorted_flight_details() {

	}

}
