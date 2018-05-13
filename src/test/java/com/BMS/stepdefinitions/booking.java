package com.BMS.stepdefinitions;

import org.junit.Assert;

import com.BMS.TestUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class booking extends TestUtils {

	@Given("^user open the browser$")
	public void user_open_the_browser() {
		dr = getDriver();

	}

	@When("^User navigate to the application  \"(.*?)\" url$")
	public void user_navigate_to_the_application_url(String url) {

		dr.navigate().to(url);

	}

	@Then("^validate the user in \"(.*?)\" of Bookmyshow$")
	public void validate_the_user_in_of_Bookmyshow(String page) {
		verifyPage(page);

	}

	@Given("^User click on the \"(.*?)\" tab and redirect to \"(.*?)\"$")
	public void user_click_on_the_tab_and_redirect_to(String tabName, String page) throws Throwable {
		clickOnTab(tabName);
		verifyPage(page);
	}

	@When("^User Select the movie and click on the BookNowButton$")
	public void user_Select_the_movie_and_click_on_the_BookNowButton() throws Throwable {

		selectMovie();

	}

	@When("^User selects the date and time in respective cinemahall$")
	public void user_selects_the_date_and_time_in_respective_cinemahall() throws Throwable {
		selectDate();

	}

	@When("^User selects the (\\d+) seat and proceed$")
	public void user_selects_the_seat_and_proceed(int arg1) throws Throwable {
		selectSeat();
	}

	@Then("^selecting seat in seatt matrix and validating the both side seat is empty of Occupied$")
	public void selecting_seat_in_seatt_matrix_and_validating_the_both_side_seat_is_empty_of_Occupied()
			throws Throwable {
		checkSeat();
	}

	@Given("^go ione place$")
	public void go_ione_place() throws Throwable {
		System.out.println("hi>>>>>>>>>>>");
	}

	@When("^he went$")
	public void he_went() throws Throwable {
		System.out.println("hi>>>>>>>>>>>");
	}

	@Then("^verified$")
	public void verified() throws Throwable {
		System.out.println("hi>>>>>>>>>>>");
		try {
			Assert.assertTrue(false);
		} catch (Error e) {
			System.out.println("byeeeeee");
		}
	}

}
