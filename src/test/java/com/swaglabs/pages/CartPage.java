package com.swaglabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(className = "checkout_button")
    private WebElement checkoutButton;

    @FindBy(className = "continue_shopping")
    private WebElement continueShoppingButton;

    @FindBy(className = "cart_quantity")
    private WebElement cartQuantity;

    // Constructor
    public CartPage() {
        // Initialize elements
    }

    // Method to get cart items
    public List<WebElement> getCartItems() {
        return cartItems;
    }

    // Method to click on checkout button
    public void clickCheckout() {
        checkoutButton.click();
    }

    // Method to click on continue shopping button
    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    // Method to get cart quantity
    public String getCartQuantity() {
        return cartQuantity.getText();
    }
}