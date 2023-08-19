package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@UpdateBooking,@DeleteBooking")
	public void beforeScenario() throws IOException {
		stepDefination stp = new stepDefination();
		if (stepDefination.bookingid == null) {
			stp.add_basic_info_of_user_with("suraj", "date", "dinner");
			stp.user_call_the_api_using_http_request("CreateBooking", "post");
			stp.verify_booking_id_is_created_for_using("suraj", "GetBooking");
		}
	}
}