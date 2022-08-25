package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
	WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getAllProducts() {
		List<WebElement> products = driver.findElements(By.className("inventory_item"));
		return products;
	}
	
	public void addItemToCart(int index) {
		List<WebElement> products = getAllProducts();
		products.get(index).findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
	}
	
	public int getShoppingCartItemsCount() {
		int count = 0;
		WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
		count = Integer.valueOf(shoppingCartBadge.getText());
		return count;
	}
	
	
}
