package stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.demo.pages.CategoryPage;
import com.demo.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoryPageSteps {
	
	private CategoryPage  category = new CategoryPage(DriverFactory.getDriver());
	
	@Given("user is on flipKart site page {string}")
	public void user_is_on_flipKart_site_page(String expectedUrl) {
		String currentUrl=category.getCurrentUrl();
		Assert.assertEquals(expectedUrl, currentUrl);
	}
	
	@When("user mouse hover to fashion menu")
	public void user_mouse_hover_to_fashion_menu() throws InterruptedException {
		category.mouseHover();
	}

	@When("user click on watch and Accessories")
	public void user_click_on_watch_and_accessories() throws InterruptedException {
	category.clickOnSubCategory();
	}

	@Then("verify title should be {string}")
	public void verify_title_should_be(String expectedTitle) {
		String titile = category.getTitle();
		Assert.assertEquals(titile, expectedTitle);
	}
	
	@Then("user gets menu Category")
	public void user_gets_menu_category(DataTable dataTable) {
		List<String> actualMenuCategories = category.getMenuCategoryList();
		System.out.println("Actual List "+actualMenuCategories);
		List<String> expectedMenuCategories=dataTable.asList();
		System.out.println("Actual List "+expectedMenuCategories);
		Assert.assertTrue(actualMenuCategories.containsAll(expectedMenuCategories));

	}
	

	@Then("Menu Category should be {int}")
	public void menu_category_should_be(int expectedCount) {
		int actualCount = category.getMenuCategoryCount();
		System.out.println("Actual categories count "+actualCount);
		System.out.println("Expected categories count "+expectedCount);
		Assert.assertEquals(expectedCount, actualCount); 
	}


}
