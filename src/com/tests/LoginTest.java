package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends TestBase {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals(pageURL, "https://www.saucedemo.com/inventory.html");
	}

	@Test
	public void negativeLoginTest() {
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("random_user", "secret_sauce");

		WebElement errorMsg = driver.findElement(By.cssSelector(".error-message-container.error"));
		Assert.assertEquals(errorMsg.isDisplayed(), true);
	}

}
