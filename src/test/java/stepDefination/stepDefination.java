package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;

import com.test.constants.APIResources;
import com.test.utilities.Testdatabuild;
import com.test.utilities.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String bookingid;
	Testdatabuild data = new Testdatabuild();

	@Given("add basic info of user with {string} {string}  {string}")
	public void add_basic_info_of_user_with(String firstname, String lastname, String additionalneeds)
			throws IOException {
		res = given().spec(requestSpecification())
				.body(data.createBookingPayload(firstname, lastname, additionalneeds));
	}

	@When("user call the {string} api using {string} http request")
	public void user_call_the_api_using_http_request(String resource, String method) {
		APIResources resourseAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourseAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(resourseAPI.getResource() + bookingid);
		else if (method.equalsIgnoreCase("PUT"))
			response = res.when().put(resourseAPI.getResource() + bookingid);
		else if (method.equalsIgnoreCase("DELETE"))
			response = res.when().delete(resourseAPI.getResource() + bookingid);
	}

	@Then("validate with http response code {string}")
	public void validate_with_http_response_code(String resCode) {
		Assert.assertEquals(String.valueOf(response.getStatusCode()), resCode);
	}

	@Then("verify bookingID is created for {string} using {string}")
	public void verify_booking_id_is_created_for_using(String expName, String resource) throws IOException {
		bookingid = getJsonPath(response, "bookingid");
		res = given().spec(requestSpecification());
		user_call_the_api_using_http_request(resource, "get");
		String actualName = getJsonPath(response, "firstname");
		assertEquals(actualName, expName);
	}

	@Given("user calls request api for {string}")
	public void user_calls_request_api_for(String bookingid)throws IOException {
		this.bookingid=bookingid;
		res = given().spec(requestSpecification());
	}
}