package stepdef;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://adactinhotelapp.com/");
	}

	@When("user get the title of the page")
	public void user_get_the_title_of_the_page() {
		title = loginPage.getTitle();
		System.out.println("Login page title is :" + title);
		

	}

	@Then("page tittle should be {string}")
	public void page_tittle_should_be(String expectedValue) {

		Assert.assertTrue(title.contains(expectedValue));

	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enter username {string}")
	public void user_enter_username(String username) {
		loginPage.enterUsername(username);
	}

	@When("user enter password {string}")
	public void user_enter_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLogin();
	}

	
	


}
