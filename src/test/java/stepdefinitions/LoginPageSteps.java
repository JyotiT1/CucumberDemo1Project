package stepdefinitions;

import org.junit.Assert;

import com.demo.pages.LoginPage;
import com.demo.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginpage= new LoginPage(DriverFactory.getDriver());
	
	@Given("navigate user to application page")
	public void navigate_user_to_application_page() {	
		DriverFactory.getDriver().get("https://www.flipkart.com/");
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String atualtitle = loginpage.getApplicationPageTitle();
		System.out.println("Title : "+atualtitle); 
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String atualtitle = loginpage.getApplicationPageTitle();
		Assert.assertEquals(atualtitle, expectedTitle);
	}

	
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		//DriverFactory.getDriver().get("https://www.flipkart.com/");
		loginpage.clickOnLogin();
	}
	

	@When("user enters blank Request OTP {string}")
	public void user_enters_blank_request_otp(String emailOrPhone) {
		loginpage.enterEmailOrMobile(emailOrPhone);
	}
	

	@Then("Request OTP button link should be displayed")
	public void request_otp_button_link_should_be_displayed() {
	}

	@Then("New to Flipkart? Create an account link should be displayed")
	public void new_to_flipkart_create_an_account_link_should_be_displayed() {
	}

	@When("user clicks on Request OTP button")
	public void user_clicks_on_request_otp_button() {
		loginpage.clickOnRequestOtp();
	}

	@Then("verify validation messaage {string}")
	public void verify_validation_messaage(String expectedValidation) {
		String atualtitle = loginpage.getRequestotpBlankValidation();
		Assert.assertEquals(atualtitle, expectedValidation);
	}

}
