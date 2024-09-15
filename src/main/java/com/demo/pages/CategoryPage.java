package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategoryPage {

	private WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	private By category = By.cssSelector("div[aria-label='Fashion']");
	private By subCategory = By.cssSelector("div._16rZTH > object > a:nth-child(6)");
	private By menuCategories = By.cssSelector("div[class='_3sdu8W emupdz'] *[class='_1ch8e_']");

	public void mouseHover() throws InterruptedException {
		WebElement el = driver.findElement(category);
		Actions actions = new Actions(driver);
		actions.moveToElement(el).perform();
	}

	public void clickOnSubCategory() throws InterruptedException {
		driver.findElement(subCategory).click();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public int getMenuCategoryCount() {
		return driver.findElements(menuCategories).size(); 
	}
	
	public List<String>  getMenuCategoryList() {
		List<String> ls = new ArrayList<String>(); 
		List<WebElement> categoriesList= driver.findElements(menuCategories);
		for(WebElement el:categoriesList) {
			ls.add(el.getText());
		}
		return ls;
	}
}
