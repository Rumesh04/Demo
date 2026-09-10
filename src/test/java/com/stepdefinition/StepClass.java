package com.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.baseclass.BaseClass;
import com.pomclass.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepClass extends BaseClass{
	
	PomClass pom = new PomClass();

	@Given("User launches the Php Travels application")
	public void user_launches_the_php_travels_application() {
		driver.get("https://phptravels.net/");
		WaitImpletic();
		button(pom.getHandlePopUp());

	}

	@When("User Clicks Flight module from Service section")
	public void user_clicks_flight_module_from_service_section() {

		visibleOfElement(pom.getClickFlightsModule());
		elementToClickable(pom.getClickFlightsModule());
		button(pom.getClickFlightsModule());

	}

	@Then("User Navigate to flight search page and page title should be {string}")
	public void user_navigate_to_flight_search_page_and_page_title_should_be(String string) {
		visibleOfElement(pom.getClickDepartureField());
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains(string));

	}

	@When("User clicks Departure field and Enter the Departure city")
	public void user_clicks_departure_field_and_enter_the_departure_city() {
		button(pom.getClickDepartureField());
		setText(pom.getEnterCityName(), "Chennai");
	}

	@When("User Selects the city from suggestions")
	public void user_selects_the_city_from_suggestions() {
		visibleOfElement(pom.getSelectTheCity());
		button(pom.getSelectTheCity());
	}

	@When("User clicks Arrival field and Enter the Arrival city")
	public void user_clicks_arrival_field_and_enter_the_arrival_city() {
		button(pom.getClickArrivalField());
		setText(pom.getEnterArrivalCityName(), "Delhi");
	}

	@When("User selects the city from suggestion")
	public void user_selects_the_city_from_suggestion() {
		visibleOfElement(pom.getSelectTheArrivalCity());
		button(pom.getSelectTheArrivalCity());
	}

	@When("User clicks Departure date field and selects the date")
	public void user_clicks_departure_date_field_and_selects_the_date() throws InterruptedException {
		button(pom.getClickDepartureDate());
		Thread.sleep(1000);
		date("21");
	}

	@When("User clicks Search icon button")
	public void user_clicks_search_icon_button() {
		visibleOfElement(pom.getClickSearch());
		hiddenButton(pom.getClickSearch());
	}

	@Then("Verify that User navigate to Flight Search result page is displayed")
	public void verify_that_user_navigate_to_flight_search_result_page_is_displayed() {
		wait.until(ExpectedConditions.urlContains("/flights"));
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("/flights"));
		System.out.println(url);
	}

	@When("User clicks Sort Dropdown and Selects {string}")
	public void user_clicks_sort_dropdown_and_selects(String string) {
//	    elementToClickable(pom.getClickDropDown());
//	    button(pom.getClickDropDown());
//	    select(pom.getClickDropDown(), string);
		// Assert.assertTrue(false);
	}

	@Then("User Checks sort dropdown has displayed {string}")
	public void user_checks_sort_dropdown_has_displayed(String string) {
//    String text = pom.getCheckSortOption().getText();
//    Assert.assertTrue(text.equals(string));
//    System.out.println(text);
	}

	@When("User Checks the Price Range slider")
	public void user_checks_the_price_range_slider() {
		sliderRanger(pom.getSlider(), pom.getSliderRange());
	}

	@When("User clicks {string} Flight from search result page")
	public void user_clicks_flight_from_search_result_page(String string) {
		try {
			visibleOfAllElement(pom.getTotalFlights());
			int flights = pom.getTotalFlights().size();
			System.out.println("Total number of flight in search result page: " + flights);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebElement> totalFlights = pom.getTotalFlights();
		boolean clicked = false;
		for (int i = 0; i < totalFlights.size(); i++) {
//			try {
//			Assert.assertTrue(pom.getTotalFlights().get(i).getText().contains(string));
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			//System.out.println(pom.getTotalFlights().get(i).getText() + "|");
//			hiddenButton(pom.getClickBookBtn());
//		}
			if (pom.getTotalFlights().get(i).getText().contains(string)) {
				scrollIntoView(pom.getClickBookBtn());
				hiddenButton(pom.getClickBookBtn());
				clicked = true;
				break;
			}
		}

	}

	@Then("User should navigate to the Booking details page")
	public void user_should_navigate_to_the_booking_details_page() {
		wait.until(ExpectedConditions.urlContains("/booking"));
		String url = currentUrl();
		Assert.assertTrue(url.contains("/booking"));
		System.out.println(url);
	}

	@When("User select the title")
	public void user_select_the_title() {
		visibleOfElement(pom.getSelectTitle());
		button(pom.getSelectTitle());
		select(pom.getSelectTitle(), "Mr");
	}

	@When("User enters {string} in the first name field")
	public void user_enters_in_the_first_name_field(String string) {
		setText(pom.getEnterFirstName(), string);
	}

	@When("User enters {string} in the last name field")
	public void user_enters_in_the_last_name_field(String string) {
		setText(pom.getEnterLasttName(), string);
	}

	@When("User enter {string} in the email field")
	public void user_enter_in_the_email_field(String string) throws InterruptedException {
		try {
			hiddenButton(pom.getEnterEmail());
			setText(pom.getEnterEmail(), string);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User selects the country code")
	public void user_selects_the_country_code() {
		button(pom.getSelectCountryCode());
		select(pom.getClickCountryCode(), "IN +91");

	}

	@When("User enters {string} in the phone number field")
	public void user_enters_in_the_phone_number_field(String string) {
		setText(pom.getEnterPhNo(), string);

	}

	@When("User Scrolls to Passenger Details section")
	public void user_scrolls_to_passenger_details_section() {
		scroll(pom.getScrollToPassengerDetail());

	}

	@When("User Selects the Nationality")
	public void user_selects_the_nationality() {
		select(pom.getSelectNationality(), "India");

	}

	@When("User Enters the Passport Number")
	public void user_enters_the_passport_number() {
		setText(pom.getEnterPassportCode(), "456789");

	}

	@When("User checks I agree to the policy and condition listbox")
	public void user_checks_i_agree_to_the_policy_and_condition_listbox() {
		button(pom.getClickListBox());

	}

	@When("User clicks the confirm Booking button")
	public void user_clicks_the_confirm_booking_button() throws IOException {
		scroll(pom.getClickConfirmBtn());
		hiddenButton(pom.getClickConfirmBtn());

	}

	@Then("User should be navigate to Invoice detials page")
	public void user_should_be_navigate_to_invoice_detials_page() throws IOException {
		wait.until(ExpectedConditions.urlContains("/invoice"));
		String url = currentUrl();
		Assert.assertTrue(url.contains("/invoice"));
		System.out.println(url);
		shot();

	}


}
