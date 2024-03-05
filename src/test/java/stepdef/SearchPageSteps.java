package stepdef;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.SearchPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private SearchPage searchPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		DriverFactory.getDriver().get("https://adactinhotelapp.com/");
		List<Map<String, String>> asMaps = dataTable.asMaps();
		String user = asMaps.get(0).get("username");
		String pass = asMaps.get(0).get("password");
		searchPage = loginPage.doLogin(user, pass);

	}

	@Given("user is on search page")
	public void user_is_on_search_page() {
		String title = searchPage.getSearchPageTitle();
		System.out.println("Search page title :" + title);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("user gets search section")
	public void user_gets_search_section(DataTable dataTable) {
		List<String> expectedSearchList = dataTable.asList();
		System.out.println("Expected Search List :" + expectedSearchList);

		List<String> actualSearchList = searchPage.getSearchSectionList();
		System.out.println("Actual Search List :" + actualSearchList);

		Assert.assertTrue(expectedSearchList.containsAll(actualSearchList));

	}

	@Then("search section count should be {int}")
	public void search_section_count_should_be(Integer expectedSearchCount) {
		Assert.assertTrue(searchPage.getSearchSectionCount() == expectedSearchCount);
	}

}
