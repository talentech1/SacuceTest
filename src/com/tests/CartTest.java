package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.InventoryPage;
import com.pages.LoginPage;

public class CartTest extends TestBase {

	@Test
	public void addItemsTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		InventoryPage inventoryPage = new InventoryPage(driver);

		inventoryPage.addItemToCart(0);
		Assert.assertEquals(inventoryPage.getShoppingCartItemsCount(), 1);

		inventoryPage.addItemToCart(3);
		Assert.assertEquals(inventoryPage.getShoppingCartItemsCount(), 2);

	}

}
