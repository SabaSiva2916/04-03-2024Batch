package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	private WebDriver driver;

	private By searchSection = By.xpath("//table[@class='login']//td[@align='right']");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSearchPageTitle() {
		return driver.getTitle();

	}

	public int getSearchSectionCount() {

		return driver.findElements(searchSection).size();
	}

	public List<String> getSearchSectionList() {
		List<String> search = new ArrayList<String>();
		List<WebElement> searchSectionList = driver.findElements(searchSection);

		for (WebElement ele : searchSectionList) {
			String text = ele.getText();
			String trim = text.trim();
			System.out.println(trim);
			search.add(trim);

		}
		return search;
	}
}
