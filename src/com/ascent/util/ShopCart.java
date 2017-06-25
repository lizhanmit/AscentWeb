package com.ascent.util;

import java.util.HashMap;

import com.ascent.bean.Product;

public class ShopCart {
	
	private HashMap<String, CartItem> hashmap;

	public ShopCart() {
		this.hashmap = new HashMap<String, CartItem>(); 
	}

	/**
	 * check if this id has already in the hashmap, this is to say, if this product has already in the shop cart
	 * @param id
	 * @return
	 */
	public boolean checkHashMapid(String pid) {
		boolean b = false; 
		if (hashmap.containsKey(pid)) {
			b = true;
		}
		return b; 
	}
	
	public void addProduct(String pid, Product product) {
		if (pid != null) {
			if (checkHashMapid(pid)) {
				CartItem item = (CartItem) hashmap.get(pid);
				item.incre();
			} else {
				CartItem item = new CartItem(product);
				hashmap.put(pid, item);
			}
		}
 	}
	
	/**
	 * remove this product from the shop cart
	 * @param pid
	 */
	public void removeCartItem(String pid) {
		hashmap.remove(pid);
	}
	
	public void updateProductNumber(String pid, int quantity) {
		hashmap.get(pid).setQuantity(quantity);
	}
	
	public void emptyCart() {
		hashmap.clear();
	}

	public HashMap<String, CartItem> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, CartItem> hashmap) {
		this.hashmap = hashmap;
	}
	
	
}
