package com.ascent.util;

import com.ascent.bean.Product;

public class CartItem {
	
	private Product product;
	private int quantity;
	
	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
	} 
	
	public double getCartItemPrice() {
		return product.getPrice() * quantity;
	}
	
	// the number of the bought product increases by 1
	public void incre() {
		quantity++;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
